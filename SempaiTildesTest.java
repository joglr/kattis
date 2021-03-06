import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SempaiTildesTest {

  public static void main(String[] args) throws IOException {

    Stopwatch total = new Stopwatch("total");
    // for (int iiii = 0; iiii < 500; iiii++) {
    for (int i = 0; i < 3; i++) {

      File inputFile = new File("tilde-tests/" + (i + 1) + ".in");
      File outputFile = new File("tilde-tests/" + (i + 1) + ".ans");

      Scanner inputReader = new Scanner(inputFile);
      Scanner outputReader = new Scanner(outputFile);

      int n = inputReader.nextInt();
      int q = inputReader.nextInt();
      inputReader.nextLine();
      SempaiTildes tildes = new SempaiTildes(n, q);

      boolean happy = true;

      while (inputReader.hasNextLine()) {
        // Stopwatch sw = new Stopwatch("readLine");
        String line = inputReader.nextLine();
        String[] inputArray = line.split(" ");
        List<String> inputs = new ArrayList<>(Arrays.asList(inputArray));

        int[] nums = new int[inputs.size()];
        for (int ii = 0; i < inputs.size(); i++) {
          nums[ii] = Integer.parseInt(inputs.get(ii));
        }

        int output = tildes.receiveInput(inputArray);
        // System.out.print(line + " ");

        if (output != -1) {

          // System.out.print(output);
          int expectedOutputValue = outputReader.nextInt();

          if (output != (expectedOutputValue)) {
            happy = false;

            // System.out.print(" ❌ wrong output, expected: " + expectedOutputValue);

            // for (int num : nums)
            // System.out.print(num + " ");
            // System.out.println();
          } else {
            // System.out.print(" ✔");
          }

        }
        // System.out.println();
      }

      System.out.println(happy ? "yay 🎉" : " something is wrong...🤔 ");

      inputReader.close();

      outputReader.close();
      // System.out.println("");
    }
    // }
    total.printEllapsedTimeInMs();
  }

  public static int[] parseLine(String input, String delimiter) {
    return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
  }
}
