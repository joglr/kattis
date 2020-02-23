import java.util.*;

class SempaiTildes {
    public int[] parentOf;
    public int[] sizes;
    String out = "";
    StringBuilder outBuilder = new StringBuilder();

    public SempaiTildes(int n, int m) {
        // initialize variables
        parentOf = new int[n];
        sizes = new int[n];

        for (var i = 0; i < n; i++) {
            parentOf[i] = i;
            sizes[i] = 1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n m
        String[] init = sc.nextLine().split(" ");
        int n = Integer.valueOf(init[0]);
        int m = Integer.valueOf(init[1]);
        SempaiTildes sempaiTildes = new SempaiTildes(n, m);

        // Output

        // traverse lines

        for (var i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            sempaiTildes.receiveInput(line);

        }

        System.out.print(sempaiTildes.getOut());

        // the end
        sc.close();
    }

    /**
     * @return the out
     */
    public String getOut() {
        return outBuilder.toString();
    }

    public int receiveInput(String[] line) {
        switch (line[0]) {
        case "s":

            // Stopwatch sw = new Stopwatch("size");
            int size = getSize(findRoot(Integer.valueOf(line[1]) - 1));

            // sw.printEllapsedTimeInMs();
            // out += size + "\n";
            outBuilder.append(size + "\n");
            return size;

        case "t":

            // Stopwatch sw2 = new Stopwatch("merge");
            merge(Integer.valueOf(line[1]) - 1, Integer.valueOf(line[2]) - 1);
            // sw2.printEllapsedTimeInMs();
            return -1;
        default:
            return -1;
        }
    }

    public int getSize(int site) {
        return sizes[site];
    }

    public void debugArray(Object in) {
        Object[] arr = (Object[]) in;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void merge(int siteOne, int siteTwo) {
        // Find root of each

        Stopwatch sw = new Stopwatch("findRoot");
        var rootOne = findRoot(siteOne);
        var rootTwo = findRoot(siteTwo);
        sw.printEllapsedTimeInMs();

        Stopwatch sw2 = new Stopwatch("merge");
        // If same root, skip
        if (rootOne == rootTwo)
            return;

        // Get count of each
        if (getSize(rootOne) >= getSize(rootTwo)) {
            // Change small sites to big sites
            changeTo(rootTwo, rootOne);
            // Change count
            sizes[rootOne] += sizes[rootTwo];
            sizes[rootTwo] = sizes[rootOne];
        } else {
            // Change small sites to big sites
            changeTo(rootOne, rootTwo);
            // Change count
            sizes[rootTwo] += sizes[rootOne];
            sizes[rootOne] = sizes[rootTwo];
        }

        sw2.printEllapsedTimeInMs();

    }



    public void changeTo(int from, int to) {
        for (var i = 0; i < parentOf.length; i++) {
            if (parentOf[i] == from) {
                parentOf[i] = to;
            }
        }
    }

    public int findRoot(int site) {
        // DO NOT recurse function, just simulate it
        // Is root? return
        if (site == parentOf[site]) {
            return site;
        }

        var newSite = parentOf[site];

        while (true) {
            if (newSite == parentOf[newSite]) {
                return newSite;
            }
            newSite = parentOf[newSite];
        }
    }
}
