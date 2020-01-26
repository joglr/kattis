package detaileddifferences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class detaileddifferences {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int entryCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < entryCount; i++) {
            String lineOne = reader.readLine();
            String lineTwo = reader.readLine();
            System.out.println(lineOne);
            System.out.println(lineTwo);
            String[] lineOneChars = lineOne.split("");
            String[] lineTwoChars = lineTwo.split("");

            for (int ii = 0; ii < lineOne.length(); ii++) {
                if (lineOneChars[ii].equals(lineTwoChars[ii])) System.out.print(".");
                else System.out.print("*");
            }        
            System.out.println("");    

        }
    }
}