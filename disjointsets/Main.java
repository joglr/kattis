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

  private int query(int s, int t) {
    return id[s] == id[t] ? 1 : 0;
  }

  private void union(int s, int t) {
    int S = id[s];
    int T = id[t];

    if (query(s, t) == 1)
      return;

    for (int i = 0; i < n - 1; i++) {
      if (id[i] == S) {
        id[i] = T;
      }
    }

  }

  private void move(int s, int t) {
    if (s == t)
      return;
    for (int i = 0; i < n - 1; i++) {
      if (id[i] == s)
        id[i] = t;
    }

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
