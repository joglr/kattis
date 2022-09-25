using System;

namespace addtwonumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            String str = Console.ReadLine();
            String[] arr = str.Split(" ");
            System.Console.WriteLine(int.Parse(arr[0]) + int.Parse(arr[1]));
        }
    }
}
