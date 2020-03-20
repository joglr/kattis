import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * Harmony
 */
public class Harmony implements Testable {
  Graph graph;

  @Override
  public String getTestsFolder() {
    return "itu.harmony";
  }

  @Override
  public int getTestCount() {
    return 4;
  }

  @Override
  public String run(Reader in) throws IOException {
    Scanner sc = new Scanner(in);
    int[] nums = Test.getIntsFromLine(sc.nextLine());

    int numVertices = nums[0];
    int numEdges = nums[1];

    Edge[] edges = new Edge[numEdges];
    graph = new Graph(numVertices);

    for (int i = 0; i < numEdges; i++) {
      int[] edgeNums = Test.getIntsFromLine(sc.nextLine());

      int u = edgeNums[0];
      int v = edgeNums[1];
      // int c = edgeNums[2];
      graph.addEdge(u, v);
      // edges[i] = new Edge(u, v, c);
    }

    sc.close();

    // Can G be harmoniously 2-coloured?
    Bipartite bf = new Bipartite(graph);

    return bf.isBipartite() ? "1" : "0";
  }

  // String f(String str) {
  //   return String.format("%1$" + width + "s", str);
  // }

  // private String isTwoColorable() {
  //   for (int v = 0; v < graph.V(); v++) {
  //     for (int w : graph.adj(v)) {
  //         BreadthFirstPaths bfp = new BreadthFirstPaths(graph, );
  //         G)
  //     }
  //   }

  // }

  public static void main(String[] args) throws IOException {
    System.out.println(new Harmony().run(new InputStreamReader(System.in)));
  }
}

class Edge {
  public int start;
  public int stop;
  public int isConflict;

  public Edge(int _start, int _stop, int _isConflict) {
    start = _start;
    stop = _stop;
    isConflict = _isConflict;
  }
}
