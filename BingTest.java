import java.io.IOException;

/**
 * BingTest
 */
public class BingTest extends Test {

  public BingTest() throws IOException {
    super();
  }

  @Override
  Testable instantiateTestable() {
    return new Bing();
  }

  public static void main(String[] args) throws IOException {
    new BingTest();
  }
}
