using System;
using System.Collections.Generic;
using System.Linq;

namespace laptopsticker
{
    class Program
    {
        static void Main(string[] args)
        {
            String str = Console.ReadLine();
            var arr = str.Split(" ").Select(x => int.Parse(x)).ToArray();
            int lw = arr[0] - 2; // Laptop Width
            int lh = arr[1] - 2; // Laptop Height
            int sw = arr[2]; // Sticker Width
            int sh = arr[3]; // Sticker Height

            System.Console.WriteLine(lw >= sw && lh >= sh ? "1" : "0");
        }
    }
}
 