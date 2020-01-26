package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class io {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        do {
            line = reader.readLine();
            System.out.println(Output.getOutput(line));
        } while(line  != null);

        
        // while(String line = reader.readLine() != null) {
            
        // }
    }
}
