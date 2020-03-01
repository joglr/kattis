import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public abstract class Test {

  abstract Testable instantiateTestable();

  public Test() throws IOException {
    this(null);
  }

  public Test(Integer testID) throws IOException {
    Testable testable = instantiateTestable();
    // // Stopwatch total = new Stopwatch("total");

    if (testID == null) {
      for (int i = 1; i <= testable.getTestCount(); i++) {
        runTest(testable, i);
      }
    } else runTest(testable, testID);

    // total.printEllapsedTimeInMs("ran " + testable.getTestCount() + " tests from
    // folder " + testable.getTestsFolder());

    System.out.println();
  }

  private void runTest(Testable testable, int i) throws IOException {
    FileReader inputFile = new FileReader(
      testable.getTestsFolder() + "/" + (i) + ".in"
    );
    FileReader expectedOutputFile = new FileReader(
      testable.getTestsFolder() + "/" + (i) + ".ans"
    );

    BufferedReader inputReader = new BufferedReader(inputFile);
    BufferedReader expectedOutputReader = new BufferedReader(
      expectedOutputFile
    );

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

  public static int[] getIntsFromLine(String input, String delimiter) {
    return Arrays
      .stream(input.split(delimiter))
      .mapToInt(Integer::parseInt)
      .toArray();
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
