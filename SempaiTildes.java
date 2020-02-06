import java.util.*;

class SempaiTildes {
    public Integer[] parentOf;
    public Integer[] sizes;
    String out = "";

    public SempaiTildes(Integer n, Integer m) {
        // initialize variables
        parentOf = new Integer[n];
        sizes = new Integer[n];

        for (var i = 0; i < n; i++) {
            parentOf[i] = i;
            sizes[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n m
        String[] init = sc.nextLine().split(" ");
        Integer n = Integer.valueOf(init[0]);
        Integer m = Integer.valueOf(init[1]);
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
        return out;
    }

    public Integer receiveInput(String[] line) {
        switch (line[0]) {
        case "s":
            Integer size = getSize(findRoot(Integer.valueOf(line[1]) - 1));
            out += size + "\n";
            return size;

        case "t":
            merge(Integer.valueOf(line[1]) - 1, Integer.valueOf(line[2]) - 1);
            return null;
        default:
            return null;
        }
    }

    public Integer getSize(Integer site) {
        return sizes[site];
    }

    public void debugArray(Object in) {
        Object[] arr = (Object[]) in;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void merge(Integer siteOne, Integer siteTwo) {
        // Find root of each
        var rootOne = findRoot(siteOne);
        var rootTwo = findRoot(siteTwo);

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
    }

    public void changeTo(Integer from, Integer to) {
        for (var i = 0; i < parentOf.length; i++) {
            if (parentOf[i] == from) {
                parentOf[i] = to;
            }
        }
    }

    public Integer findRoot(Integer site) {
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
