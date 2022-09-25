using System;
using System.Globalization;

namespace betting
{
  class Program
  {
    static void Main(string[] args)
    {
      int optionAPercentage = int.Parse(Console.ReadLine());
      int optoinBPercentage = 100 - optionAPercentage;
      double A = 100f / optionAPercentage;
      double B = 100f / optoinBPercentage;
      System.Console.WriteLine((A).ToString("0.0000000000", new CultureInfo("en-US")));
      System.Console.WriteLine((B).ToString("0.0000000000", new CultureInfo("en-US")));
    }
  }
}
