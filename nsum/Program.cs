using System;
using System.Linq;

namespace nsum
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int[] nums = Console
                .ReadLine()
                .Split()
                .Select(x => int.Parse(x))
                .ToArray();

            int sum = 0;

            for(int i = 0; i < N; i++) {
                sum += nums[i];
            }
            System.Console.WriteLine(sum);
        }
    }
}
