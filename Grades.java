import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Grades
 */
public class Grades implements Testable {

  @Override
  public String getTestsFolder() {
    return "sempai4_1";
  }

  @Override
  public int getTestCount() {
    return 2;
  }

  @Override
  public String run(Reader in) throws IOException {
    BufferedReader br = new BufferedReader(in);
    int N = Integer.parseInt(br.readLine());
    // String[][] lines = new String[N][2];
    TreeSet<String[]> studentSet = new TreeSet<String[]>(new GradeComparator());
    // TreeMap<String, Grade> gradesMap = new TreeMap<>(GradeComparator);
    for (int i = 0; i < N; i++) {
      String[] pieces = Test.getStringsFromLine(br.readLine());
      studentSet.add(pieces);
    }

    StringBuilder out = new StringBuilder();
    Set<String[]> sortedStudentSet = studentSet.descendingSet();
    for (String[] student : sortedStudentSet) {
      out.append(student[0] + "\n");
    }
    // for (String[] student : sortedStudentSet) {
    // System.out.println(
    // Arrays.asList(sortedStudentSet.toArray()).indexOf(student) + ": " +
    // student[1] + ", " + student[0]);
    // }
    return out.toString();
  }

  public static void main(String[] args) throws IOException {
    System.out.println(new Grades().run(new InputStreamReader(System.in)));
  }
}

class GradeComparator implements Comparator<String[]> {
  List<String> baseGrades = Arrays.asList(
    new String[] { "A", "B", "C", "D", "E", "FX", "F" }
  );

  @Override
  public int compare(String[] stud1, String[] stud2) {
    double gv1 = gradeValue(stud1[1]);
    double gv2 = gradeValue(stud2[1]);
    if (gv1 == gv2) return stud1[0].compareToIgnoreCase(stud2[0]) * -1;
    return gv1 > gv2 ? 1 : -1;
  }

  double gradeValue(String gradeString) {
    String[] parts = gradeString.split("\\b");
    int base = baseGrades.size() - baseGrades.indexOf(parts[0]);
    double extra = 0;
    String[] extraParts = parts.length == 2
      ? parts[1].split("")
      : new String[0];
    for (String string : extraParts) {
      if (string.equals("+")) extra++; else if (string.equals("-")) extra--;
    }
    extra /= 1000;
    // double extra = parts.length == 2 ? Math.log10(parts[1].length() + 1) *
    // (parts[1].startsWith("+") ? 1 : -1) : 0;
    // System.out.println(gradeString + ": " + ((Double) (base + extra)).toString()
    // + ", b:" + base + ", e: " + extra);
    return base + extra;
  }
}
