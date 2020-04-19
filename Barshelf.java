import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Barshelf
 */
public class Barshelf implements Testable {

  @Override
  public String getTestsFolder() {
    return "barshelf";
  }

  @Override
  public int getTestCount() {
    return 3;
  }

  @Override
  public String run(Reader in) throws IOException {
    Scanner sc = new Scanner(in);
    // int count = sc.nextInt();
    sc.nextLine();

    int[] nums = Test.getIntsFromLine(sc.nextLine());

    int messyTripletCount = countMessyTriplets(nums);

    sc.close();

    return String.valueOf(messyTripletCount);
  }

  int countMessyTriplets(int[] nums) {
    // Loop through all the numbers
    int messyTripletCount = 0;
    for (int i = 0; i < nums.length; i++) {
      //
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          int[] triplet = new int[] { nums[i], nums[j], nums[k] };
          int x = triplet[0];
          int y = triplet[1];
          int z = triplet[2];
          if (x >= 2 * y && y >= 2 * z) {
            messyTripletCount++;
          }
        }
      }
    }
    return messyTripletCount;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(new Barshelf().run(new InputStreamReader(System.in)));
  }
}
