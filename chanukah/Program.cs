using System;
using System.Collections.Generic;

namespace chanukah
{
    class Program
    {
        static Dictionary<int, int> facCache = new Dictionary<int, int>();

        static void Main(string[] args)
        {
            facCache.Add(0, 0);
            int P = int.Parse(Console.ReadLine());

            for(int i = 0; i < P; i++) {
                string[] parts = Console.ReadLine().Split(" ");
                int K = int.Parse(parts[0]); // ID
                int N = int.Parse(parts[1]); // Number of days
                System.Console.WriteLine(K + " " + (sumPrev(N + 1) - 1));
            }
        }

        static int sumPrev(int i) {
            if (facCache.TryGetValue(i, out var n)) {
                return n;
            }
            else return sumPrev(i - 1) + i;
        }

    }
}
