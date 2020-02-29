import java.io.IOException;

/**
 * SeatAllocationTest
 */
public class SeatAllocationTest extends Test {

  public SeatAllocationTest() throws IOException {
    super();
  }

  @Override
  Testable instantiateTestable() {
    return new SeatAllocation();
  }

  public static void main(String[] args) throws IOException {
    new SeatAllocationTest();
  }
}
