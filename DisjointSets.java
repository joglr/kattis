
/**
IN
4 9
0 0 1
1 0 1
0 0 1
1 1 2
0 1 2
0 0 3
1 2 3
0 2 3
0 0 3

OUT
0
1
1
0
1
1
 */
import java.util.*;

class DisjointSets {
   public Integer[] id;

   public static void main(String args[]) {
      DisjointSets DS = new DisjointSets();
      Scanner sc = new Scanner(System.in);

      String[] init = sc.nextLine().split(" ");

      Integer n = Integer.valueOf(init[0]);
      Integer m = Integer.valueOf(init[1]);

      DS.id = new Integer[n];

      for (int i = 0; i < n; i++) {
         DS.id[i] = i;
      }

      for (int i = 0; i < m; i++) {
         String[] input = sc.nextLine().split(" ");
         Integer s = Integer.valueOf(input[1]);
         Integer t = Integer.valueOf(input[2]);

         switch (Integer.valueOf(input[0])) {
         case 0:
            System.out.println((DS.query(s, t)) ? 1 : 0);
            break;
         case 1:
            DS.union(s, t);
            break;
         case 2:
            DS.move(s, t);
            break;
         }
      }

      sc.close();
   }

   private Boolean query(Integer s, Integer t) {
      return findRoot(this.id[s]) == findRoot(this.id[t]);
   }

   private void union(Integer s, Integer t) {
      this.id[s] = t;
   }

   private Integer findRoot(Integer x) {
      if (x == this.id[x]) {
         return x;
      } else {
         return this.findRoot(this.id[x]);
      }
   }

   public void move(final int s, final int t) {
      final Integer S = this.findRoot(s);
      final int T = this.findRoot(t);
      if (S == T)
         return;

      this.id[s] = T;

   }

   // private void move(Integer s, Integer t) {
   // Integer root = this.findRoot(t);
   // this.id[s] = root;
   // }
}
