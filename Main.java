public class Main {
  private final int[] id; // parent[i] = parent of i
  private final int[] size; // size[i] = number of elements in subtree rooted at i
  private int count; // number of components

  /**
   * Initializes an empty union-find data structure with {@code n} elements
   * {@code 0} through {@code n-1}. Initially, each elements is in its own set.
   *
   * @param n the number of elements
   * @throws IllegalArgumentException if {@code n < 0}
   */
  public Main(final int n) {
    count = n;
    id = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }

  /**
   * Returns the number of sets.
   *
   * @return the number of sets (between {@code 1} and {@code n})
   */
  public int count() {
    return count;
  }

  /**
   * Returns the canonical element of the set containing element {@code p}.
   *
   * @param p an element
   * @return the canonical element of the set containing {@code p}
   * @throws IllegalArgumentException unless {@code 0 <= p < n}
   */
  public int find(int p) {
    validate(p);
    while (p != id[p])
      p = id[p];
    return p;
  }

  /**
   * Returns true if the two elements are in the same set.
   *
   * @param p one element
   * @param q the other element
   * @return {@code true} if {@code p} and {@code q} are in the same set;
   *         {@code false} otherwise
   * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
   *                                  {@code 0 <= q < n}
   * @deprecated Replace with two calls to {@link #find(int)}.
   */
  @Deprecated
  public boolean connected(final int p, final int q) {
    return find(p) == find(q);
  }

  // validate that p is a valid index
  private void validate(final int p) {
    final int n = id.length;
    if (p < 0 || p >= n) {
      throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
    }
  }

  /**
   * Merges the set containing element {@code p} with the the set containing
   * element {@code q}.
   *
   * @param s one element
   * @param t the other element
   * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
   *                                  {@code 0 <= q < n}
   */
  public void union(final int s, final int t) {
    final int S = find(s);
    final int T = find(t);
    if (S == T)
      return;

    // make smaller root point to larger one
    if (size[S] < size[T]) {
      id[S] = T;
      size[T] += size[S];
    } else {
      id[T] = S;
      size[S] += size[T];
    }
    count--;
  }

  public void move(final int s, final int t) {
    final int S = find(s);
    final int T = find(t);
    if (S == T)
      return;

    // if (size[S] < size[T]) {
    id[s] = T;
    size[T] += size[S];
    // } else {
    // id[T] = S;
    // size[S] += size[T];
    // }

  }

  /**
   * Reads in a an integer {@code n} and a sequence of pairs of integers (between
   * {@code 0} and {@code n-1}) from standard input, where each integer in the
   * pair represents some element; if the elements are in different sets, merge
   * the two sets and print the pair to standard output.
   *
   * @param args the command-line arguments
   */

  public Boolean receiveInput(final int[] numbers) {
    /* Assumptions */
    // 0 ≤ s < n
    // 0 ≤ t < n
    // m ≥ 1

    final int operation = numbers[0];
    final int s = numbers[1];
    final int t = numbers[2];

    switch (operation) {
    case 0:
      Boolean connected = connected(s, t);
      System.out.println(connected(s, t) ? 1 : 0);
      return connected;
    case 1:
      union(s, t);
      return null;
    case 2:
      move(s, t);
      return null;
    default:
      throw new IllegalArgumentException(" *** unknown operation:" + operation);
    }
  }

  public static void main(final String[] args) {
    final int n = StdIn.readInt();
    final int m = StdIn.readInt();
    final Main uf = new Main(n);
    for (int i = 0; i < m; i++) {
      final int p = StdIn.readInt();
      final int q = StdIn.readInt();
      final int r = StdIn.readInt();
      final int[] nums = new int[] { p, q, r };
      uf.receiveInput(nums);
    }
  }

}
