package uge5.Roman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    File file = new File("roman.txt");

    BufferedReader br = new BufferedReader(new FileReader(file));

    String st;

    int failed = 0;
    int succeeded = 0;
    int total = 0;
    while ((st = br.readLine()) != null) {
      total++;
      String[] elms = st.split(" ");
      String roman = elms[0].trim();
      int num = Integer.parseInt(elms[1]);
      Integer actual = Roman.fromRoman(roman);

      if (actual == null || actual != num) {
        System.out.println("FAIL");
        System.out.println("  Roman: " + roman);
        System.out.println("  Expected: " + num);
        System.out.println("  Actual: " + actual);
        failed++;
      } else {
        // System.out.println("PASS");
        succeeded++;
      }
    }
    System.out.println("Failed: " + failed);
    System.out.println("Succeeded: " + succeeded);
    System.out.println("Total: " + total);

    br.close();

  }

}
