/**
 * Stopwatch
 */
public class Stopwatch {
  long startTime;
  long stopTime;
  String label;

  public Stopwatch(String _label) {
    label = _label;
    startTime = System.nanoTime();
  }

  public void recordEllapsedTime() {
    stopTime = System.nanoTime();
  }

  public long getRecordedTime() {
    stopTime = System.nanoTime();
    return (stopTime - startTime) / 1000;
  }

  public long getEllapsedTimeInMs() {
    return (System.nanoTime() - startTime) / 1000;
  }

  public void printEllapsedTimeInMs() {
    printEllapsedTimeInMs("");
  }

  public void printEllapsedTimeInMs(String extra) {
    System.out.println(label + ": " + getEllapsedTimeInMs() + "ms (" + extra + ")");
  }
}
