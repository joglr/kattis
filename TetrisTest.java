import java.io.IOException;

public class TetrisTest extends Test {

  public TetrisTest() throws IOException {
    super();
  }


	@Override
	Testable instantiateTestable() {
    return new Tetris();
  }

  public static void main(String[] args) throws IOException {
    new TetrisTest();
  }
}
