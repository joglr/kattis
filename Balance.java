import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.InvalidParameterException;

/**
 * Balance
 */
public class Balance implements Testable {
  Stack stack;
  StringBuilder out = new StringBuilder();

  public String run() throws Exception {
    return run(new InputStreamReader(System.in));
  }

  public String run(Reader inStream) throws NumberFormatException, IOException {
    BufferedReader in = new BufferedReader(inStream);

    int n = Integer.parseInt(in.readLine());
    if (n % 2 != 0) return "0";
    int i = 0;
    int t = in.read();
    stack = new Stack(n);

    do {
      String input = String.valueOf((char) t);
      String popped;

      switch (input) {
        case "[":
        case "(":
          stack.push(input);
          break;
        case ")":
          popped = stack.pop();
          if (popped != null && popped.equals("(")) break; else return "0";
        case "]":
          popped = stack.pop();
          if (popped != null && popped.equals("[")) break; else return "0";
        default:
          throw new InvalidParameterException("invalid");
      }
      i++;
      t = in.read();
    } while (t != -1 && i < n);

    in.close();
    return stack.getPointer() == 0 ? "1" : "0";
  }

  @Override
  public String getTestsFolder() {
    return "itu.balance";
  }

  @Override
  public int getTestCount() {
    return 12;
  }

  public static void main(String[] args) throws Exception {
    System.out.println(new Balance().run());
  }

  /**
   * Stack
   */
  private class Stack {
    private String[] stack;
    private int pointer = 0;

    public Stack(int n) {
      stack = new String[n];
    }

    public void push(String str) {
      stack[pointer] = str;
      pointer++;
    }

    public String pop() {
      if (pointer == 0) return null;
      pointer--;
      String poppedItem = stack[pointer];
      return poppedItem;
    }

    /**
     * @return the pointer
     */
    public int getPointer() {
      return pointer;
    }
  }
}
