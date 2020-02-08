import java.io.FileNotFoundException;

/**
 * BalanceTest
 */
public class BalanceTest extends Test {

  public BalanceTest() throws FileNotFoundException {
    super();
  }

  Testable balance;

  @Override
  Testable instantiateTestable() {
    balance = new Balance();
    return balance;
  }

  public static void main(String[] args) throws FileNotFoundException {
    new BalanceTest();
  }

}
