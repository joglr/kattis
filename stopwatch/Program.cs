using System;

public class Program {
    public static void Main(string[] args) {
      int timesPressed = int.TryParse(Console.ReadLine(), out timesPressed) ? timesPressed : 0;

      if (timesPressed % 2 != 0) {
        Console.WriteLine("still running");
        return;
      }

      bool running = false;
      int prevTime = 0;
      int time = 0;

      for (int i = 0; i < timesPressed; i++) {
        int input = int.TryParse(Console.ReadLine(), out input) ? input : 0;

        if (running) {
          time += input - prevTime;
        }

        prevTime = input;
        running = !running;
      }
      System.Console.WriteLine(time);
    }
}
