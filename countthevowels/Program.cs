using System;

public class Program
{
  public static void Main()
  {
    // Read line from std.in
    string line = Console.ReadLine().ToLower();

    int stringLength = line.Length;
    int vowelCount = 0;

    for (int i = 0; i < stringLength; i++)
    {
      char c = line[i];
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
      {
        vowelCount++;
      }
    }
    System.Console.WriteLine(vowelCount);
  }
}
