import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * Bing
 */
public class Bing implements Testable {

  @Override
  public String getTestsFolder() {
    return "bing";
  }

  @Override
  public int getTestCount() {
    return 1;
  }

  @Override
  public String run(Reader in) throws IOException {
    StringBuilder output = new StringBuilder();
    Scanner sc = new Scanner(in);
    int count = sc.nextInt();
    sc.nextLine();

    int firstCharCode = 97;

    String[] words = new String[count];

    for (int i = 0; i < count; i++) {
      String str = sc.nextLine();
      words[i] = str;
      int prevStartsWithCount = 0;

      for (int j = 0; j < i; j++) {
        String otherString = words[j];
        if (otherString.startsWith(str))
          prevStartsWithCount++;
      }

      output.append(prevStartsWithCount);
      output.append("\n");
    }

    sc.close();

    return output.toString();
  }

  public static void main(String[] args) throws IOException {
    System.out.println(new Bing().run(new InputStreamReader(System.in)));
  }
}
