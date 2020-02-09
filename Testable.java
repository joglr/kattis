import java.io.IOException;
import java.util.Scanner;

interface Testable {

  String getTestsFolder();

  int getTestCount();

  String run(Scanner in) throws IOException;

}
