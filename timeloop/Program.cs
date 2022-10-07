using System;

namespace timeloop
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            for(int i = 0; i < num; i++) {
                System.Console.WriteLine((i+ 1) + " Abracadabra");
            }
        }
    }
}
