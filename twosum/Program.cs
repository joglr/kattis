using System;

namespace twosum
{
  class Program
  {
    static void Main(string[] args)
    {
      String line = Console.ReadLine();
      string[] parts = line.Split(' ');
      int a = int.Parse(parts[0]);
      int b = int.Parse(parts[1]);
      System.Console.WriteLine(a + b);
    }
  }
}
