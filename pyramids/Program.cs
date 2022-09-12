using System;

public class Program {
    public static void Main(string[] args) {
        double n = double.TryParse(Console.ReadLine(), out n) ? n : 0;

        double height = 1;
        double blocks = 1;

        while(true) {
            double layerWidth = height * 2 + 1;
            double next = blocks + layerWidth * layerWidth;
            if (next > n) {
              System.Console.WriteLine(height);
              break;
            }
            blocks = next;
            height++;
        }
    }
}
