import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Barshelf
 */
public class Barshelf implements Testable {
  Graph graph;

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
    Set<int[]> messyTriplets = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        for (int k = 0; k < nums.length; k++) {
          int[] triplet = new int[] { nums[i], nums[j], nums[k] };
          Arrays.sort(triplet);
          if (triplet[0] >= 2 * triplet[1] && triplet[1] >= 2 * triplet[2])
            messyTriplets.add(triplet);
        }
      }
    }
    return messyTriplets.size();
  }

  public static void main(String[] args) throws IOException {
    System.out.println(new Barshelf().run(new InputStreamReader(System.in)));
  }
}
