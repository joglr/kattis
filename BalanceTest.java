import java.io.IOException;

/**
 * BalanceTest
 */
public class BalanceTest extends Test {

  public BalanceTest() throws IOException {
    super();
  }

  Testable balance;

  @Override
  Testable instantiateTestable() {
    balance = new Balance();
    return balance;
  }

  public static void main(String[] args) throws IOException {
    new BalanceTest();
  }

}
