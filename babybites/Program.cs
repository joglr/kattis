using System;

namespace babybites
{
  class Program
  {
    static void Main(string[] args)
    {
      int n = int.Parse(Console.ReadLine());
      string[] input = Console.ReadLine().Split(' ');

      for (int i = 0; i < n; i++)
      {
        bool didParse = int.TryParse(input[i], out int result);
        if (didParse && result != i + 1)
        {
          Console.WriteLine("something is fishy");
          return;
        }
      }
      System.Console.WriteLine("makes sense");
    }
  }
}
