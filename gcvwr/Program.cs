using System;
using System.Collections.Generic;
using System.Linq;

namespace gcvwr
{
  class Program
  {
    static void Main(string[] args)
    {
      float maxRatio = 0.9f;


      string line = Console.ReadLine();
      string[] parts = line.Split(' ');

      // Gross Combined Vehicle Weight Rating (lbs)
      int G = int.Parse(parts[0]);

      // Vehicle Weight in (lbs)
      int T = int.Parse(parts[1]);

      // Number of items to bring camping
      int N = int.Parse(parts[2]);

      string line2 = Console.ReadLine();
      int itemsTotalWeight = line2
          .Split(' ')
          .AsEnumerable()
          .Select(x => int.Parse(x))
          .Sum();

      int remainingTowingCapacity = G - T;

      // itemsTotalWeight + trailerWeight = maxRatio * remainingTowingCapacity
      float trailerWeight = maxRatio * remainingTowingCapacity - itemsTotalWeight;

      Console.WriteLine(trailerWeight);
    }
  }
}
