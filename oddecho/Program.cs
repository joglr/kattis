using System;

namespace oddecho
{
  class Program
  {
    static void Main(string[] args)
    {
      int n = int.Parse(Console.ReadLine());
      for (int i = 0; i < n; i++)
      {
        String str = Console.ReadLine();
        if (i % 2 == 0)
        {
          System.Console.WriteLine(str);
        }
      }
    }
  }
}
