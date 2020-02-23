import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainTest {
  public static void main(String[] args) throws IOException {

    for (int i = 0; i < 3; i++) {

      File inputFile = new File("sempai/sample-input-" + (i + 1) + ".txt");
      File outputFile = new File("sempai/sample-output-" + (i + 1) + ".txt");

      Scanner br = new Scanner(new FileReader(inputFile));
      Scanner br2 = new Scanner(new FileReader(outputFile));

      int length = br.nextInt();
      br.nextLine();
      Main uf = new Main(length);

      boolean happy = true;

      while (br.hasNextLine()) {
        int[] numbers = parseLine(br.nextLine(), " ");
        int p = numbers[0];
        int q = numbers[1];
        int r = numbers[2];
        int[] nums = new int[] { p, q, r };
        Boolean output = uf.receiveInput(nums);

        if (output != null) {
          int outputValue = output ? 1 : 0;
          int expectedOutputValue = br2.nextInt();

          if (outputValue != (expectedOutputValue)) {
            happy = false;

            System.out.print("^ wrong output, expected: " + expectedOutputValue);

            System.out.println();
            for (int n : nums)
              System.out.print(n + " ");
            System.out.println();
          }

        }
      }

      System.out.println(happy ? " 🎉" : " 💩");

      br.close();
      br2.close();
      System.out.println("");
    }
  }

  public static int[] parseLine(String input, String delimiter) {
    return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
  }
}
