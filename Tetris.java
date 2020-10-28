import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Tetris implements Testable {
  public static void main(String[] args) throws IOException {
    System.out.println(new Tetris().run(new InputStreamReader(System.in)));
  }

  @Override
  public String getTestsFolder() {
    return "tetris";
  }

  @Override
  public int getTestCount() {
    return 3;
  }

  @Override
  public String run(Reader in) throws IOException {
    Scanner sc = new Scanner(in);

    var pieceOrientations = new int[][][] {
      // 1
      new int[][] {
        new int[] { 0 },
        new int[] { 0, 0, 0, 0 }
      },
      // 2
      new int[][] {
        new int[] { 0, 0 }
      },
      // 3
      new int[][] {
        new int[] { 0, 0, 1},
        new int[] { 0, -1}
      },
      // 4
      new int[][] {
        new int[] { 0, -1, -1 },
        new int[] { 0, 1 },
      },
      // 5
      new int[][] {
        new int[] { 0, 0, 0 },
        new int[] { 0, 1 },
        new int[] { 0, -1, 0 },
        new int[] { 0, -1 },
      },
      // 6
      new int[][] {
        new int[] { 0, 0, 0 },
        new int[] { 0, 0 },
        new int[] { 0, 1, 1 },
        new int[] { 0, -2 },
      },
      // 7
      new int[][] {
        new int[] { 0, 0, 0 },
        new int[] { 0, 2 },
        new int[] { 0, 0, -1 },
        new int[] { 0, 0 },
      }
    };

    var c = sc.nextInt();
    var p = sc.nextInt();
    var pIndex = p - 1;
    sc.nextLine();

    Integer piecePlacementsCount = 0;

    int[] cols = new int[c];

    for (int i = 0; i < c; i++) {
      cols[i] = sc.nextInt();
    }

    var orientations = pieceOrientations[pIndex];
    for (int j = 0; j < orientations.length; j++) {
      var orientation = orientations[j];

      // Iterate through each position of the piece orientation, but stop before reaching the edge
      for (int k = 0; k < (c - orientation.length) + 1; k++) {
        // height at given column index
        var firstColHeight = cols[k];
        boolean fits = true;
        for (int l = 0; l < orientation.length; l++) {
          int height = cols[k + l];
          int patternHeight = orientation[l];
          if (height - firstColHeight != patternHeight) {
            fits = false;
            break;
          }
        }
        if (fits) {
          piecePlacementsCount++;
        }
      }
    }
    sc.close();

    return piecePlacementsCount.toString();
  }
}
