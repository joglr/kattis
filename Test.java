import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Test {

  abstract Testable instantiateTestable();

  public Test() throws FileNotFoundException {
    Testable testable = instantiateTestable();
    Stopwatch total = new Stopwatch("total");
    boolean happy = true;

    for (int i = 0; i < testable.getTestCount(); i++) {

      File inputFile = new File(testable.getTestsFolder() + "/" + (i + 1) + ".in");
      File outputFile = new File(testable.getTestsFolder() + "/" + (i + 1) + ".ans");

      Scanner inputReader = new Scanner(inputFile);
      Scanner outputReader = new Scanner(outputFile);

      testable.init(inputReader.nextLine());

      while (inputReader.hasNextLine()) {
        String input = inputReader.nextLine();
        Integer output = testable.receiveInput(input);

        if (output != -1) {

          System.out.print(output);
          int expectedOutputValue = outputReader.nextInt();

          if (output != expectedOutputValue) {
            happy = false;

            System.out.print(" ❌ wrong output, expected: " + expectedOutputValue);

          } else {
            System.out.print(" ✔");
          }

          System.out.println();
        }
      }

      inputReader.close();
      outputReader.close();
    }
    System.out.println(happy ? "yay 🎉" : " something is wrong...🤔 ");
    total.printEllapsedTimeInMs("ran " + testable.getTestCount() + " tests from folder " + testable.getTestsFolder());
  }

  public static int[] getIntsFromLine(String input, String delimiter) {
    return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
  }
}
