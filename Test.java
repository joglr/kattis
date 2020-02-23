import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public abstract class Test {

  abstract Testable instantiateTestable();

  public Test() throws IOException {
    Testable testable = instantiateTestable();
    Stopwatch total = new Stopwatch("total");

    for (int i = 0; i < testable.getTestCount(); i++) {

      FileReader inputFile = new FileReader(testable.getTestsFolder() + "/" + (i + 1) + ".in");
      FileReader expectedOutputFile = new FileReader(testable.getTestsFolder() + "/" + (i + 1) + ".ans");

      BufferedReader inputReader = new BufferedReader(inputFile);
      BufferedReader expectedOutputReader = new BufferedReader(expectedOutputFile);

      String result = testable.run(inputReader);
      String[] lines = result.split("\n");

      for (String line : lines) {

        String expectedOutput = expectedOutputReader.readLine();

        System.out.print(line);

        if (line.equals(expectedOutput)) {
          System.out.print(" ✔");
        } else {
          System.out.print(" × wrong output, expected: " + expectedOutput);
        }

        System.out.println();
      }

      inputReader.close();
      expectedOutputReader.close();
    }

    System.out.println();
    total.printEllapsedTimeInMs("ran " + testable.getTestCount() + " tests from folder " + testable.getTestsFolder());
  }

  public static int[] getIntsFromLine(String input, String delimiter) {
    return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
  }

  public static int[] getIntsFromLine(String input) {
    return getIntsFromLine(input, " ");
  }

  public static String[] getStringsFromLine(String input, String delimiter) {
    return input.split(delimiter);
  }

  public static String[] getStringsFromLine(String input) {
    return getStringsFromLine(input, " ");
  }
}
