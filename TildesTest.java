import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TildesTest {

  public static void main(String[] args) throws IOException {

    for (int i = 0; i < 3; i++) {

      File inputFile = new File("tilde-tests/" + (i + 1) + ".in");
      File outputFile = new File("tilde-tests/" + (i + 1) + ".ans");

      Scanner inputReader = new Scanner(inputFile);
      Scanner outputReader = new Scanner(outputFile);

      int n = inputReader.nextInt();
      int q = inputReader.nextInt();
      inputReader.nextLine();
      Tildes tildes = new Tildes(n, q);

      boolean happy = true;

      while (inputReader.hasNextLine()) {

        // tildes.display();
        String line = inputReader.nextLine();
        String[] inputArray = line.split(" ");
        List<String> inputs = new ArrayList<>(Arrays.asList(inputArray));

        String opStr = inputs.remove(0);
        char o = opStr.charAt(0);

        int[] nums = new int[inputs.size()];
        for (int ii = 0; i < inputs.size(); i++) {
          nums[ii] = Integer.parseInt(inputs.get(ii));
        }

        Integer output = tildes.receiveInput(o, nums);
        System.out.print(line + " ");

        if (output != null) {

          System.out.print(output);
          int expectedOutputValue = outputReader.nextInt();

          if (output != (expectedOutputValue)) {
            happy = false;

            System.out.print(" ❌  wrong output, expected: " + expectedOutputValue);

            // for (int num : nums)
            // System.out.print(num + " ");
            // System.out.println();
          } else {
            System.out.print(" ✔");
          }


        }
        System.out.println();
      }

      // tildes.display();

      System.out.println(happy ? "yay 🎉" : " something is wrong...🤔 ");

      inputReader.close();

      outputReader.close();
      System.out.println("");
    }
  }

  public static int[] parseLine(String input, String delimiter) {
    return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
  }
}
