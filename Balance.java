/**
 * Balance
 */
public class Balance implements Testable {

  StringBuilder out = new StringBuilder();
  int n;
  int balanceRound = 0;
  int balanceSquare = 0;

  @Override
  public void init(String line) {
    n = Integer.parseInt(line);
  }

  @Override
  public int receiveInput(String line) {
    // TODO Auto-generated method stub
    String[] inputs = line.split("");

    for (String input : inputs) {
      handleInput(input);
      switch (input) {
      case "(":
        balanceRound++;
        break;
      case ")":
        balanceRound--;
        break;
      case "[":
        balanceSquare++;
        break;
      case "]":
        balanceSquare--;
        break;
      }
    }

    return isBalanced();

  }

  int isBalanced() {
    return balanceRound == 0 && balanceSquare == 0 ? 1 : 0;
  }

  void handleInput(String input) {

  }

  @Override
  public String getTestsFolder() {
    return "itu.balance";
  }

  @Override
  public int getTestCount() {
    return 4;
  }

  @Override
  public String getOut() {
    return out.toString();
  }

}
