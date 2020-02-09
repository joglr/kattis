import java.io.IOException;

/**
 * BalanceTest
 */
public class BalanceTest extends Test {

  Testable balance;

  public BalanceTest() throws IOException {
    super();
  }

  @Override
  Testable instantiateTestable() {
    return new Balance();
  }

  public static void main(String[] args) throws IOException {
    new BalanceTest();
  }

}
