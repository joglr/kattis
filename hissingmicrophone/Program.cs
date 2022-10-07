using System;

namespace hissingmicrophone
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            System.Console.WriteLine(input.Contains("ss") ? "hiss" : "no hiss");
        }
    }
}
