using System;
using System.Collections.Generic;

public class Program {
    public static void Main(string[] args) {
        // Read int from stdin
        int n = int.TryParse(Console.ReadLine(), out n) ? n : 0;

        HashSet<string> prooved = new HashSet<string>();

        for (int i = 0; i < n; i++) {
          // Read string from stdin
          string line = Console.ReadLine();
          string[] sides = line.Split("->");
          string[] left = sides[0].Trim().Split(" ");

          foreach(string s in left) {
            if (!prooved.Contains(s)) {
              Console.WriteLine(i + 1);
              return;
            }
          }
          prooved.Add(sides[1].Trim());
        }
        System.Console.WriteLine("correct");

    }
}
