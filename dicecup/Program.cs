using System;

public class Program {
  static void Main() {
    String[] line = Console.ReadLine().Split(" ");
    int a = int.Parse(line[0]);
    int b = int.Parse(line[1]);
    if (b > a) {
      int temp = a;
      a = b;
      b = temp;
    }

    for (int i = b + 1; i <= a + 1; i++) {
      Console.WriteLine(i);
    }

  }
}
