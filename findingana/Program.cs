using System;

namespace findingana
{
  class Program
  {
    static void Main(string[] args)
    {
      string word = Console.ReadLine();
      int indexOfA = word.IndexOf("a");
      string ord = word.Substring(indexOfA, word.Length - indexOfA);
      System.Console.WriteLine(ord);
    }
  }
}
