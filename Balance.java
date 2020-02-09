import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Balance
 */
public class Balance implements Testable {

  StringBuilder out = new StringBuilder();
  int balanceRound = 0;
  int balanceSquare = 0;

  public String run() throws IOException {
    return run(new InputStreamReader(System.in));
  }

  public String run(Reader inStream) throws IOException {
    BufferedReader in = new BufferedReader(inStream);

    int n = Integer.parseInt(in.readLine());
    if (n % 2 != 0)
      return "0";
    int i = 0;
    int t = in.read();

    do {
      char input = (char) t;

      switch (input) {
      case '(':
        balanceRound++;
        break;
      case ')':
        if (i == 0)
          return "0";
        balanceRound--;
        break;
      case '[':
        balanceSquare++;
        break;
      case ']':
        if (i == 0)
          return "0";
        balanceSquare--;
        break;
      }
      i++;
      t = in.read();
    } while (t != -1 && i < n);

    in.close();
    return isBalanced();
  }

  String isBalanced() {
    return balanceRound == 0 && balanceSquare == 0 ? "1" : "0";
  }

  @Override
  public String getTestsFolder() {
    return "itu.balance";
  }

  @Override
  public int getTestCount() {
    return 12;
  }

  public static void main(String[] args) throws IOException {
    new Balance().run();
  }

}
