import java.io.IOException;


/**
 * Grades
 */
public class GradesTest extends Test {

    public GradesTest() throws IOException {
        super();
    }

    @Override
    Testable instantiateTestable() {
        return new Grades();
    }

    public static void main(String[] args) throws IOException {
        new GradesTest();
    }
    
}