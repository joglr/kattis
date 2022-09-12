using System;

namespace triarea
{
  class Program
  {
    static void Main(string[] args)
    {
      string line = Console.ReadLine();
      string[] parts = line.Split(' ');
      int a = int.Parse(parts[0]);
      int b = int.Parse(parts[1]);

      double result = a * b / 2.0;
      System.Console.WriteLine(result.ToString(System.Globalization.CultureInfo.InvariantCulture));
    }
  }
}
