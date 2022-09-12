using System;
using System.Text;

namespace greetings2
{
  class Program
  {
    static void Main(string[] args)
    {
      string line = Console.ReadLine();
      line = line.Remove(0, 1);
      line = line.Remove(line.Length - 1, 1);
      int eCount = line.Length * 2;

      StringBuilder sb = new StringBuilder();
      sb.Append('h');
      sb.Append('e', eCount);
      sb.Append('y');
      System.Console.WriteLine(sb.ToString());

    }
  }
}
