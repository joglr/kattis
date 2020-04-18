import java.io.IOException;

/**
 * BarshelfTest
 */
public class BarshelfTest extends Test {

  public BarshelfTest() throws IOException {
    super();
  }

  @Override
  Testable instantiateTestable() {
    return new Barshelf();
  }

  public static void main(String[] args) throws IOException {
    new BarshelfTest();
  }
}
