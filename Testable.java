import java.io.IOException;
import java.io.Reader;

interface Testable {

  String getTestsFolder();

  int getTestCount();

  String run(Reader in) throws IOException;

}
