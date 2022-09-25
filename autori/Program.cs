using System;
using System.Linq;

namespace autori
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            char[] chars = name.Split("-").Select(x => x.ToCharArray()[0]).ToArray();
            string initials = new String(chars);
            System.Console.WriteLine(initials);
        }
    }
}
