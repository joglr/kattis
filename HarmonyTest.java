import java.io.IOException;

/**
 * HarmonyTest
 */
public class HarmonyTest extends Test {

  public HarmonyTest() throws IOException {
    super();
  }

  @Override
  Testable instantiateTestable() {
    return new Harmony();
  }

  public static void main(String[] args) throws IOException {
    new HarmonyTest();
  }
}
