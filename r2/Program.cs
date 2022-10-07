using System;

namespace r2
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(" ");
            int R1 = int.Parse(input[0]);
            int S = int.Parse(input[1]);
            // S = (R1 + R2) / 2
            // R2 = 2 * S - R1
            System.Console.WriteLine(2 * S - R1);
        }
    }
}
