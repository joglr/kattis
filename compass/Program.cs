using System;

public class Program {
  public static void Main(string[] args) {
    // Read two integers from std.in
    int origin = int.TryParse(Console.ReadLine(), out origin) ? origin : 0;
    int newOrigin = ((int.TryParse(Console.ReadLine(), out newOrigin) ? newOrigin : 0) + 360) % 360;

    int diff = (newOrigin - origin + 360) % 360;
    if (diff > 180) {
      diff = diff - 360;
    }
    System.Console.WriteLine(diff);
  }
}
