import java.util.Locale;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class StdOut {

  // force Unicode UTF-8 encoding; otherwise it's system dependent
  private static final String CHARSET_NAME = "UTF-8";

  // assume language = English, country = US for consistency with StdIn
  private static final Locale LOCALE = Locale.US;

  // send output here
  private static PrintWriter out;

  // this is called before invoking any methods
  static {
    try {
      out = new PrintWriter(new OutputStreamWriter(System.out, CHARSET_NAME), true);
    } catch (final UnsupportedEncodingException e) {
      System.out.println(e);
    }
  }

  // don't instantiate
  private StdOut() {
  }

  /**
   * Terminates the current line by printing the line-separator string.
   */
  public static void println() {
    out.println();
  }

  /**
   * Prints an object to this output stream and then terminates the line.
   *
   * @param x the object to print
   */
  public static void println(final Object x) {
    out.println(x);
  }

  /**
   * Prints a boolean to standard output and then terminates the line.
   *
   * @param x the boolean to print
   */
  public static void println(final boolean x) {
    out.println(x);
  }

  /**
   * Prints a character to standard output and then terminates the line.
   *
   * @param x the character to print
   */
  public static void println(final char x) {
    out.println(x);
  }

  /**
   * Prints a double to standard output and then terminates the line.
   *
   * @param x the double to print
   */
  public static void println(final double x) {
    out.println(x);
  }

  /**
   * Prints an integer to standard output and then terminates the line.
   *
   * @param x the integer to print
   */
  public static void println(final float x) {
    out.println(x);
  }

  /**
   * Prints an integer to standard output and then terminates the line.
   *
   * @param x the integer to print
   */
  public static void println(final int x) {
    out.println(x);
  }

  /**
   * Prints a long to standard output and then terminates the line.
   *
   * @param x the long to print
   */
  public static void println(final long x) {
    out.println(x);
  }

  /**
   * Prints a short integer to standard output and then terminates the line.
   *
   * @param x the short to print
   */
  public static void println(final short x) {
    out.println(x);
  }

  /**
   * Prints a byte to standard output and then terminates the line.
   * <p>
   * To write binary data, see {@link BinaryStdOut}.
   *
   * @param x the byte to print
   */
  public static void println(final byte x) {
    out.println(x);
  }

  /**
   * Flushes standard output.
   */
  public static void print() {
    out.flush();
  }

  /**
   * Prints an object to standard output and flushes standard output.
   *
   * @param x the object to print
   */
  public static void print(final Object x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints a boolean to standard output and flushes standard output.
   *
   * @param x the boolean to print
   */
  public static void print(final boolean x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints a character to standard output and flushes standard output.
   *
   * @param x the character to print
   */
  public static void print(final char x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints a double to standard output and flushes standard output.
   *
   * @param x the double to print
   */
  public static void print(final double x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints a float to standard output and flushes standard output.
   *
   * @param x the float to print
   */
  public static void print(final float x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints an integer to standard output and flushes standard output.
   *
   * @param x the integer to print
   */
  public static void print(final int x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints a long integer to standard output and flushes standard output.
   *
   * @param x the long integer to print
   */
  public static void print(final long x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints a short integer to standard output and flushes standard output.
   *
   * @param x the short integer to print
   */
  public static void print(final short x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints a byte to standard output and flushes standard output.
   *
   * @param x the byte to print
   */
  public static void print(final byte x) {
    out.print(x);
    out.flush();
  }

  /**
   * Prints a formatted string to standard output, using the specified format
   * string and arguments, and then flushes standard output.
   *
   *
   * @param format the <a href =
   *               "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format
   *               string</a>
   * @param args   the arguments accompanying the format string
   */
  public static void printf(final String format, final Object... args) {
    out.printf(LOCALE, format, args);
    out.flush();
  }

  /**
   * Prints a formatted string to standard output, using the locale and the
   * specified format string and arguments; then flushes standard output.
   *
   * @param locale the locale
   * @param format the <a href =
   *               "http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax">format
   *               string</a>
   * @param args   the arguments accompanying the format string
   */
  public static void printf(final Locale locale, final String format, final Object... args) {
    out.printf(locale, format, args);
    out.flush();
  }

  /**
   * Unit tests some of the methods in {@code StdOut}.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {

    // write to stdout
    StdOut.println("Test");
    StdOut.println(17);
    StdOut.println(true);
    StdOut.printf("%.6f\n", 1.0 / 7.0);
  }

}
