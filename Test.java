import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Test {

  abstract Testable instantiateTestable();

  public Test() throws IOException {
    Testable testable = instantiateTestable();
    Stopwatch total = new Stopwatch("total");
    boolean happy = true;

    for (int i = 0; i < testable.getTestCount(); i++) {

      File inputFile = new File(testable.getTestsFolder() + "/" + (i + 1) + ".in");
      File outputFile = new File(testable.getTestsFolder() + "/" + (i + 1) + ".ans");

      Scanner inputReader = new Scanner(inputFile);
      Scanner expectedOutputReader = new Scanner(outputFile);

      String result = testable.run(inputReader);
      String[] lines = result.split("\n");

      for (String line : lines) {

        String expectedOutput = expectedOutputReader.nextLine();

        System.out.print(line);

        if (line.equals(expectedOutput)) {
          System.out.print(" ✔");
        } else {
          happy = false;

          System.out.print(" ❌ wrong output, expected: " + expectedOutput);
        }

        System.out.println();
      }

      inputReader.close();
      expectedOutputReader.close();
    }

    System.out.println(happy ? "yay 🎉" : " something is wrong...🤔 ");
    total.printEllapsedTimeInMs("ran " + testable.getTestCount() + " tests from folder " + testable.getTestsFolder());
  }

  public static int[] getIntsFromLine(String input, String delimiter) {
    return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
  }
}
