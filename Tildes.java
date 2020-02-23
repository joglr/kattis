import java.util.ArrayList;
import java.util.List;

public class Tildes {

  public int[] parentOf;
  public int[] sizes;
  private int n;
  // private int q;
  private List<Integer> output;

  /**
   * @param n number of guests
   * @param q number of queries
   */
  public Tildes(int _n, int _q) {
    n = _n;
    // q = _q;

    parentOf = new int[n];
    sizes = new int[n];
    for (int i = 0; i < n; i++) {
      parentOf[i] = i;
      sizes[i] = 1;
    }

    output = new ArrayList<>();
  }

  public Integer receiveInput(char operation, int[] numbers) {
    switch (operation) {
    case 's':
      int guest = numbers[0];
      int size = getSize(guest);
      output.add(size);
      return size;
    case 't':
      final int a = numbers[0];
      final int b = numbers[1];

      // for (int i = 0; i < n )

      merge(a, b);
      return null;
    default:
      throw new IllegalArgumentException(" *** unknown operation:" + operation);
    }
  }

  // private void merge(int a, int b) {

  // for (int i = 0; i < parentOf.length; i++) {
  // if (parentOf[i] == parentOf[a]) { // if i belongs to the same set as a,
  // // sizes[parentOf[i]] -= 1;
  // // sizes[parentOf[b]] += 1;
  // parentOf[i] = parentOf[b];
  // }
  // }

  // }

  private int getSize(int guest) {
    return sizes[guest];
  }

  public Integer getSize(Integer site) {
    return sizes[site];
  }

  public void debugArray(Object in) {
    Object[] arr = (Object[]) in;
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public void merge(Integer siteOne, Integer siteTwo) {
    // Find root of each
    var rootOne = findRoot(siteOne);
    var rootTwo = findRoot(siteTwo);

    // If same root, skip
    if (rootOne == rootTwo)
      return;

    // Get count of each
    if (getSize(rootOne) >= getSize(rootTwo)) {
      // Change small sites to big sites
      changeTo(rootTwo, rootOne);
      // Change count
      sizes[rootOne] += sizes[rootTwo];
      sizes[rootTwo] = sizes[rootOne];
    } else {
      // Change small sites to big sites
      changeTo(rootOne, rootTwo);
      // Change count
      sizes[rootTwo] += sizes[rootOne];
      sizes[rootOne] = sizes[rootTwo];
    }
  }

  public void changeTo(Integer from, Integer to) {
    for (var i = 0; i < parentOf.length; i++) {
      if (parentOf[i] == from) {
        parentOf[i] = to;
      }
    }
  }

  public Integer findRoot(Integer site) {
    // DO NOT recurse function, just simulate it
    // Is root? return
    if (site == parentOf[site]) {
      return site;
    }

    var newSite = parentOf[site];

    while (true) {
      if (newSite == parentOf[newSite]) {
        return newSite;
      }
      newSite = parentOf[newSite];
    }
  }

  // public void display() {
  // List<Integer>[] groups = new ArrayList[n];
  // for (int i = 0; i < n; i++)
  // groups[i] = new ArrayList<Integer>();
  // for (int i = 0; i < n; i++) {

  // groups[parentOf[i]].add(i + 1);
  // }
  // for (int i = 0; i < groups.length; i++) {
  // List<Integer> group = groups[i];
  // if (group.size() == 0)
  // continue;
  // System.out.println("Group " + i + " (size " + sizes[i] + "):");
  // System.out.print("[");
  // for (Integer ii : group) {
  // System.out.print(ii + " ");
  // }
  // System.out.print("]");
  // System.out.println();
  // }
  // System.out.println();
  // }

  /**
   * @return the output
   */
  public List<Integer> getOutput() {
    // Todo: check what's faster: using Sys.out.print or concatenate Integer array
    return output;
  }

  public static void main(final String[] args) {
    final int n = StdIn.readInt();
    final int q = StdIn.readInt();
    final Tildes tildes = new Tildes(n, q);

    for (int i = 0; i < q; i++) {
      char o = StdIn.readChar();
      int[] nums = StdIn.readAllInts();
      tildes.receiveInput(o, nums);
    }
  }

}

/**
 * Line
 */
class Line {
  char op;
  int[] nums;

  public Line(String line) {

  }

  /**
   * @return the nums
   */
  public int[] getNums() {
    return nums;
  }

  /**
   * @return the op
   */
  public char getOp() {
    return op;
  }

}
