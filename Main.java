import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {
	private final int[] id; // parent[i] = parent of i
	private final int[] size; // size[i] = number of elements in subtree rooted at i
	private int count; // number of components

	/**
	 * Initializes an empty union-find data structure with {@code n} elements
	 * {@code 0} through {@code n-1}. Initially, each elements is in its own set.
	 *
	 * @param n the number of elements
	 * @throws IllegalArgumentException if {@code n < 0}
	 */
	public Main(final int n) {
		count = n;
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
  }
  
  

	/**
	 * Returns the number of sets.
	 *
	 * @return the number of sets (between {@code 1} and {@code n})
	 */
	public int count() {
		return count;
	}

	/**
	 * Returns the canonical element of the set containing element {@code p}.
	 *
	 * @param p an element
	 * @return the canonical element of the set containing {@code p}
	 * @throws IllegalArgumentException unless {@code 0 <= p < n}
	 */
	public int find(int p) {
		validate(p);
		while (p != id[p])
			p = id[p];
		return p;
	}

	/**
	 * Returns true if the two elements are in the same set.
	 * 
	 * @param p one element
	 * @param q the other element
	 * @return {@code true} if {@code p} and {@code q} are in the same set;
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
	 *                                  {@code 0 <= q < n}
	 * @deprecated Replace with two calls to {@link #find(int)}.
	 */
	@Deprecated
	public boolean connected(final int p, final int q) {
		return find(p) == find(q);
	}

	// validate that p is a valid index
	private void validate(final int p) {
		final int n = id.length;
		if (p < 0 || p >= n) {
			throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
		}
	}

	/**
	 * Merges the set containing element {@code p} with the the set containing
	 * element {@code q}.
	 *
	 * @param s one element
	 * @param t the other element
	 * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
	 *                                  {@code 0 <= q < n}
	 */
	public void union(final int s, final int t) {
		final int S = find(s);
		final int T = find(t);
		if (S == T)
			return;

		// make smaller root point to larger one
		if (size[S] < size[T]) {
			id[S] = T;
			size[T] += size[S];
		} else {
			id[T] = S;
			size[S] += size[T];
		}
		count--;
	}
  
	public void move(final int s, final int t) {
		final int S = find(s);
		final int T = find(t);
		if (S == T)
			return;

    
		// if (size[S] < size[T]) {
			id[s] = T;
			size[T] += size[S];
		// } else {
		// 	id[T] = S;
		// 	size[S] += size[T];
		// }
		
	}
	/**
	 * Reads in a an integer {@code n} and a sequence of pairs of integers (between
	 * {@code 0} and {@code n-1}) from standard input, where each integer in the
	 * pair represents some element; if the elements are in different sets, merge
	 * the two sets and print the pair to standard output.
	 * 
	 * @param args the command-line arguments
	 */

	public void receiveInput(final int[] numbers) {
		/* Assumptions */
		// 0 ≤ s < n
		// 0 ≤ t < n
		// m ≥ 1

		final int operation = numbers[0];
		final int s = numbers[1];
		final int t = numbers[2];

		switch (operation) {
		case 0:
			final boolean result = connected(s, t);
			System.out.println(result ? 1 : 0);
			break;
		case 1:
			union(s, t);
			break;
		case 2:
			move(s, t);
			break;
		default:
			throw new IllegalArgumentException(" *** unknown operation:" + operation);
		}
	}

	public static void main(final String[] args) {
		final int n = StdIn.readInt();
		final int m = StdIn.readInt();
		final Main uf = new Main(n);
    for (int i = 0; i < m; i++) {
			final int p = StdIn.readInt();
			final int q = StdIn.readInt();
			final int r = StdIn.readInt();
			final int[] nums = new int[] { p, q, r };
      uf.receiveInput(nums);
		}
	}

}

class StdIn {

  /*** begin: section (1 of 2) of code duplicated from In to StdIn. */
  
  // assume Unicode UTF-8 encoding
  private static final String CHARSET_NAME = "UTF-8";

  // assume language = English, country = US for consistency with System.out.
  private static final Locale LOCALE = Locale.US;

  // the default token separator; we maintain the invariant that this value
  // is held by the scanner's delimiter between calls
  private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

  // makes whitespace significant
  private static final Pattern EMPTY_PATTERN = Pattern.compile("");

  // used to read the entire input
  private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

  /*** end: section (1 of 2) of code duplicated from In to StdIn. */

  private static Scanner scanner;

  // it doesn't make sense to instantiate this class
  private StdIn() { }

  //// begin: section (2 of 2) of code duplicated from In to StdIn,
  //// with all methods changed from "public" to "public static"

 /**
   * Returns true if standard input is empty (except possibly for whitespace).
   * Use this method to know whether the next call to {@link #readString()}, 
   * {@link #readDouble()}, etc will succeed.
   *
   * @return {@code true} if standard input is empty (except possibly
   *         for whitespace); {@code false} otherwise
   */
  public static boolean isEmpty() {
      return !scanner.hasNext();
  }

 /**
   * Returns true if standard input has a next line.
   * Use this method to know whether the
   * next call to {@link #readLine()} will succeed.
   * This method is functionally equivalent to {@link #hasNextChar()}.
   *
   * @return {@code true} if standard input has more input (including whitespace);
   *         {@code false} otherwise
   */
  public static boolean hasNextLine() {
      return scanner.hasNextLine();
  }

  /**
   * Returns true if standard input has more input (including whitespace).
   * Use this method to know whether the next call to {@link #readChar()} will succeed.
   * This method is functionally equivalent to {@link #hasNextLine()}.
   *
   * @return {@code true} if standard input has more input (including whitespace);
   *         {@code false} otherwise
   */
  public static boolean hasNextChar() {
      scanner.useDelimiter(EMPTY_PATTERN);
      final boolean result = scanner.hasNext();
    scanner.useDelimiter(WHITESPACE_PATTERN);
    return result;
  }

  /**
   * Reads and returns the next line, excluding the line separator if present.
   *
   * @return the next line, excluding the line separator if present; {@code null}
   *         if no such line
   */
  public static String readLine() {
    String line;
    try {
      line = scanner.nextLine();
    } catch (final NoSuchElementException e) {
      line = null;
    }
    return line;
  }

  /**
   * Reads and returns the next character.
   *
   * @return the next {@code char}
   * @throws NoSuchElementException if standard input is empty
   */
  public static char readChar() {
    try {
      scanner.useDelimiter(EMPTY_PATTERN);
      final String ch = scanner.next();
      assert ch.length() == 1 : "Internal (Std)In.readChar() error!" + " Please contact the authors.";
      scanner.useDelimiter(WHITESPACE_PATTERN);
      return ch.charAt(0);
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attempts to read a 'char' value from standard input, " + "but no more tokens are available");
    }
  }

  /**
   * Reads and returns the remainder of the input, as a string.
   *
   * @return the remainder of the input, as a string
   * @throws NoSuchElementException if standard input is empty
   */
  public static String readAll() {
    if (!scanner.hasNextLine())
      return "";

    final String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
    // not that important to reset delimeter, since now scanner is empty
    scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
    return result;
  }

  /**
   * Reads the next token and returns the {@code String}.
   *
   * @return the next {@code String}
   * @throws NoSuchElementException if standard input is empty
   */
  public static String readString() {
    try {
      return scanner.next();
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attempts to read a 'String' value from standard input, " + "but no more tokens are available");
    }
  }

  /**
   * Reads the next token from standard input, parses it as an integer, and
   * returns the integer.
   *
   * @return the next integer on standard input
   * @throws NoSuchElementException if standard input is empty
   * @throws InputMismatchException if the next token cannot be parsed as an
   *                                {@code int}
   */
  public static int readInt() {
    try {
      return scanner.nextInt();
    } catch (final InputMismatchException e) {
      final String token = scanner.next();
      throw new InputMismatchException(
          "attempts to read an 'int' value from standard input, " + "but the next token is \"" + token + "\"");
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attemps to read an 'int' value from standard input, " + "but no more tokens are available");
    }

  }

  /**
   * Reads the next token from standard input, parses it as a double, and returns
   * the double.
   *
   * @return the next double on standard input
   * @throws NoSuchElementException if standard input is empty
   * @throws InputMismatchException if the next token cannot be parsed as a
   *                                {@code double}
   */
  public static double readDouble() {
    try {
      return scanner.nextDouble();
    } catch (final InputMismatchException e) {
      final String token = scanner.next();
      throw new InputMismatchException(
          "attempts to read a 'double' value from standard input, " + "but the next token is \"" + token + "\"");
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attempts to read a 'double' value from standard input, " + "but no more tokens are available");
    }
  }

  /**
   * Reads the next token from standard input, parses it as a float, and returns
   * the float.
   *
   * @return the next float on standard input
   * @throws NoSuchElementException if standard input is empty
   * @throws InputMismatchException if the next token cannot be parsed as a
   *                                {@code float}
   */
  public static float readFloat() {
    try {
      return scanner.nextFloat();
    } catch (final InputMismatchException e) {
      final String token = scanner.next();
      throw new InputMismatchException(
          "attempts to read a 'float' value from standard input, " + "but the next token is \"" + token + "\"");
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attempts to read a 'float' value from standard input, " + "but there no more tokens are available");
    }
  }

  /**
   * Reads the next token from standard input, parses it as a long integer, and
   * returns the long integer.
   *
   * @return the next long integer on standard input
   * @throws NoSuchElementException if standard input is empty
   * @throws InputMismatchException if the next token cannot be parsed as a
   *                                {@code long}
   */
  public static long readLong() {
    try {
      return scanner.nextLong();
    } catch (final InputMismatchException e) {
      final String token = scanner.next();
      throw new InputMismatchException(
          "attempts to read a 'long' value from standard input, " + "but the next token is \"" + token + "\"");
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attempts to read a 'long' value from standard input, " + "but no more tokens are available");
    }
  }

  /**
   * Reads the next token from standard input, parses it as a short integer, and
   * returns the short integer.
   *
   * @return the next short integer on standard input
   * @throws NoSuchElementException if standard input is empty
   * @throws InputMismatchException if the next token cannot be parsed as a
   *                                {@code short}
   */
  public static short readShort() {
    try {
      return scanner.nextShort();
    } catch (final InputMismatchException e) {
      final String token = scanner.next();
      throw new InputMismatchException(
          "attempts to read a 'short' value from standard input, " + "but the next token is \"" + token + "\"");
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attempts to read a 'short' value from standard input, " + "but no more tokens are available");
    }
  }

  /**
   * Reads the next token from standard input, parses it as a byte, and returns
   * the byte.
   *
   * @return the next byte on standard input
   * @throws NoSuchElementException if standard input is empty
   * @throws InputMismatchException if the next token cannot be parsed as a
   *                                {@code byte}
   */
  public static byte readByte() {
    try {
      return scanner.nextByte();
    } catch (final InputMismatchException e) {
      final String token = scanner.next();
      throw new InputMismatchException(
          "attempts to read a 'byte' value from standard input, " + "but the next token is \"" + token + "\"");
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attempts to read a 'byte' value from standard input, " + "but no more tokens are available");
    }
  }

  /**
   * Reads the next token from standard input, parses it as a boolean, and returns
   * the boolean.
   *
   * @return the next boolean on standard input
   * @throws NoSuchElementException if standard input is empty
   * @throws InputMismatchException if the next token cannot be parsed as a
   *                                {@code boolean}: {@code true} or {@code 1} for
   *                                true, and {@code false} or {@code 0} for
   *                                false, ignoring case
   */
  public static boolean readBoolean() {
    try {
      final String token = readString();
      if ("true".equalsIgnoreCase(token))
        return true;
      if ("false".equalsIgnoreCase(token))
        return false;
      if ("1".equals(token))
        return true;
      if ("0".equals(token))
        return false;
      throw new InputMismatchException(
          "attempts to read a 'boolean' value from standard input, " + "but the next token is \"" + token + "\"");
    } catch (final NoSuchElementException e) {
      throw new NoSuchElementException(
          "attempts to read a 'boolean' value from standard input, " + "but no more tokens are available");
    }

  }

  /**
   * Reads all remaining tokens from standard input and returns them as an array
   * of strings.
   *
   * @return all remaining tokens on standard input, as an array of strings
   */
  public static String[] readAllStrings() {
    // we could use readAll.trim().split(), but that's not consistent
    // because trim() uses characters 0x00..0x20 as whitespace
    final String[] tokens = WHITESPACE_PATTERN.split(readAll());
    if (tokens.length == 0 || tokens[0].length() > 0)
      return tokens;

    // don't include first token if it is leading whitespace
    final String[] decapitokens = new String[tokens.length - 1];
    for (int i = 0; i < tokens.length - 1; i++)
      decapitokens[i] = tokens[i + 1];
    return decapitokens;
  }

  /**
   * Reads all remaining lines from standard input and returns them as an array of
   * strings.
   * 
   * @return all remaining lines on standard input, as an array of strings
   */
  public static String[] readAllLines() {
    final ArrayList<String> lines = new ArrayList<String>();
    while (hasNextLine()) {
      lines.add(readLine());
    }
    return lines.toArray(new String[lines.size()]);
  }

  /**
   * Reads all remaining tokens from standard input, parses them as integers, and
   * returns them as an array of integers.
   * 
   * @return all remaining integers on standard input, as an array
   * @throws InputMismatchException if any token cannot be parsed as an
   *                                {@code int}
   */
  public static int[] readAllInts() {
    final String[] fields = readAllStrings();
    final int[] vals = new int[fields.length];
    for (int i = 0; i < fields.length; i++)
      vals[i] = Integer.parseInt(fields[i]);
    return vals;
  }

  /**
   * Reads all remaining tokens from standard input, parses them as longs, and
   * returns them as an array of longs.
   * 
   * @return all remaining longs on standard input, as an array
   * @throws InputMismatchException if any token cannot be parsed as a
   *                                {@code long}
   */
  public static long[] readAllLongs() {
    final String[] fields = readAllStrings();
    final long[] vals = new long[fields.length];
    for (int i = 0; i < fields.length; i++)
      vals[i] = Long.parseLong(fields[i]);
    return vals;
  }

  /**
   * Reads all remaining tokens from standard input, parses them as doubles, and
   * returns them as an array of doubles.
   * 
   * @return all remaining doubles on standard input, as an array
   * @throws InputMismatchException if any token cannot be parsed as a
   *                                {@code double}
   */
  public static double[] readAllDoubles() {
    final String[] fields = readAllStrings();
    final double[] vals = new double[fields.length];
    for (int i = 0; i < fields.length; i++)
      vals[i] = Double.parseDouble(fields[i]);
    return vals;
  }

  //// end: section (2 of 2) of code duplicated from In to StdIn

  // do this once when StdIn is initialized
  static {
    resync();
  }

  /**
   * If StdIn changes, use this to reinitialize the scanner.
   */
  private static void resync() {
    setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
  }

  private static void setScanner(final Scanner scanner) {
    StdIn.scanner = scanner;
    StdIn.scanner.useLocale(LOCALE);
  }

  /**
   * Reads all remaining tokens, parses them as integers, and returns them as an
   * array of integers.
   * 
   * @return all remaining integers, as an array
   * @throws InputMismatchException if any token cannot be parsed as an
   *                                {@code int}
   * @deprecated Replaced by {@link #readAllInts()}.
   */
  @Deprecated
  public static int[] readInts() {
    return readAllInts();
  }

  /**
   * Reads all remaining tokens, parses them as doubles, and returns them as an
   * array of doubles.
   * 
   * @return all remaining doubles, as an array
   * @throws InputMismatchException if any token cannot be parsed as a
   *                                {@code double}
   * @deprecated Replaced by {@link #readAllDoubles()}.
   */
  @Deprecated
  public static double[] readDoubles() {
    return readAllDoubles();
  }

  /**
   * Reads all remaining tokens and returns them as an array of strings.
   * 
   * @return all remaining tokens, as an array of strings
   * @deprecated Replaced by {@link #readAllStrings()}.
   */
  @Deprecated
  public static String[] readStrings() {
    return readAllStrings();
  }

  /**
   * Interactive test of basic functionality.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {

    StdOut.print("Type a string: ");
    final String s = StdIn.readString();
    StdOut.println("Your string was: " + s);
    StdOut.println();

    StdOut.print("Type an int: ");
    final int a = StdIn.readInt();
    StdOut.println("Your int was: " + a);
    StdOut.println();

    StdOut.print("Type a boolean: ");
    final boolean b = StdIn.readBoolean();
    StdOut.println("Your boolean was: " + b);
    StdOut.println();

    StdOut.print("Type a double: ");
    final double c = StdIn.readDouble();
    StdOut.println("Your double was: " + c);
    StdOut.println();
  }

}

class StdOut {

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
      StdOut.printf("%.6f\n", 1.0/7.0);
  }

}