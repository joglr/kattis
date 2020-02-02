import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 3; i++) {

            File file = new File("sempai/sample-input-" + (i + 1) + ".txt");

            Scanner br = new Scanner(new FileReader(file));
            
            int length = br.nextInt();
            br.nextLine();
            Main uf = new Main(length);


            while (br.hasNextLine()) {
                int[] numbers = parseLine(br.nextLine(), " ");
                int p = numbers[0];
                int q = numbers[1];
                int r = numbers[2];
                int[] nums = new int[]{p,q,r};
                uf.receiveInput(nums);
                // if (uf.find(p) == uf.find(q)) continue;
                // uf.union(p, q);
                // StdOut.println(p + " " + q);
            }

            br.close();
            System.out.println("");
        }
    }
        
    public static int[] parseLine(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }
}
