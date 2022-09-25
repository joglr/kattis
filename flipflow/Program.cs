using System;
using System.Linq;

namespace flipflow
{
    class Program
    {
        static void Main(string[] args)
        {
            var nums1 = Console.ReadLine().Split(" ").Select(x => int.Parse(x)).ToArray();
            var nums2 = Console.ReadLine().Split(" ").Select(x => int.Parse(x)).ToArray();

            int t = nums1[0];
            int s = nums1[1];
            int s2 = 0;
            int n = nums1[2];

            int prevTime = nums2[0];

            bool nIsEven = n % 2 == 0;

            for(int i = 0; i < n; i++) {
                bool even = i % 2 == 0;

                int v = nums2[i];
                if (i == 0) {
                    // ignore
                }
                if (!even) {
                    // Take from S2
                    int timePassed = Math.Min(v - prevTime, s);
                    s -= timePassed;
                    s2 += timePassed;
                } else {
                    // Take from S1
                    int timePassed = Math.Min(v - prevTime, s2);
                    s2 -= timePassed;
                    s += timePassed;
                }

                prevTime = v;
            }


            System.Console.WriteLine(nIsEven
                ? Math.Max(0, s2 - (t - prevTime))
                : Math.Max(0, s - (t - prevTime))
            );


        }
    }
}
