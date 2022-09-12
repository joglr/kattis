using System;

// Main C# CLass

class Program
{
  // Main C# method

  static void Main(string[] args)
  {

    int input = int.Parse(Console.ReadLine().Trim());
    // Print "Hello World!" to the console
    int volume = 7;

    for (int i = 0; i < input; i++) {
      String line = Console.ReadLine().Trim();
      if (line.Equals("Skru op!") ) volume++;
      else if (line.Equals("Skru ned!")) volume--;
      volume = Clamp(volume);
    }
    Console.WriteLine(volume);

  }

  // Clamp number between 0 and 10

  static int Clamp(int number)
  {
    if (number < 0) return 0;
    else if (number > 10) return 10;
    else return number;
  }
}
