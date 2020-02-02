package disjointsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  private int n; // amount of disjoint sets
  private int m; // amount of operations
  private int[] id;
  private int[] size; // size[i] = number of elements in subtree rooted at i

  
  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    new Main(reader);
  }

  public Main(BufferedReader reader) throws IOException {

    String firstLine = reader.readLine();
    Integer[] numbers = parseLine(firstLine);

    n = numbers[0];
    m = numbers[1];
    id = new int[n];
    size = new int[n];
    
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }

    for (int i = 0; i < m; i++) {
      String line = reader.readLine();
      receiveInput(line);
    }
  }

  public void receiveInput(String input) {
    /* Assumptions */
    // 0 ≤ s < n
    // 0 ≤ t < n
    // m ≥ 1
    Integer[] numbers = parseLine(input);

    int operation = numbers[0];
    int s = numbers[1];
    int t = numbers[2];

    switch (operation) {
    case 0:
      int result = query(s, t);
      System.out.println(result);
      break;
    case 1:
      union(s, t);
      break;
    case 2:
      move(s, t);
      break;
    default:
      throw new IllegalArgumentException(" *** unknown operation");
    }
  }
  
	/**
	 * Returns the number of sets.
	 *
	 * @return the number of sets (between {@code 1} and {@code n})
	 */
	public int m() {
		return m;
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
	 * @param p one element
	 * @param q the other element
	 * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
	 *                                  {@code 0 <= q < n}
	 */
	public void union(final int p, final int q) {
		final int rootP = find(p);
		final int rootQ = find(q);
		if (rootP == rootQ)
			return;

		// make smaller root point to larger one
		if (size[rootP] < size[rootQ]) {
			id[rootP] = rootQ;
			size[rootQ] += size[rootP];
		} else {
			id[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
		m--;
	}
  
	public void move(final int s, final int t) {
		final int S = find(s);
		final int T = find(t);
		if (S == T)
			return;


		// if (size[S] < size[T]) {
			id[S] = T;
			size[T] += size[S];
		// } else {
		// 	id[T] = S;
		// 	size[S] += size[T];
		// }
		m--;
	}

  private int query(int s, int t) {
    return id[s] == id[t] ? 1 : 0;
  }

  public Integer[] parseLine(String input) {
    return parseLine(input, " ");
  }

  public Integer[] parseLine(String input, String delimiter) {
    List<Integer> numbers = new ArrayList<Integer>();
    String[] parts = input.split(delimiter);

    for (String part : parts) {
      numbers.add(Integer.parseInt(part));
    }

    return ((List<Integer>) numbers).toArray(new Integer[numbers.size()]);
  }

  public int[] parseLine2(String input) {
    return parseLine2(input, " ");
  }

  public int[] parseLine2(String input, String delimiter) {
    return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
  }
}
