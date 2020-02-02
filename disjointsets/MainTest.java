package disjointsets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 3; i++) {

            File file = new File("disjointsets/sample-input-" + (i + 1) + ".txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            new Main(br);

            br.close();
            System.out.println("");
        }
    }
}
