import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] isopen;
    private int top, bottom, N;
    private WeightedQuickUnionUF uf;
    private int noofsites = 0;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Out of bounds");
        N = n;
        uf = new WeightedQuickUnionUF(n * n + 2);
        isopen = new boolean[(n * n) + 2];
        top = (n * n);
        bottom = (n * n) + 1;

    }

    private int rowcol(int row, int col) {
        return (row - 1) * N + (col - 1);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N)
            throw new IllegalArgumentException("Out of bounds");

        if (!isOpen(row, col)) {
            isopen[rowcol(row, col)] = true;
            noofsites += 1;
            if (row > 1 && isOpen(row - 1, col))
                uf.union(rowcol(row, col), rowcol(row - 1, col));
            if (row < N && isOpen(row + 1, col))
                uf.union(rowcol(row, col), rowcol(row + 1, col));
            if (col > 1 && isOpen(row, col - 1))
                uf.union(rowcol(row, col), rowcol(row, col - 1));
            if (col < N && isOpen(row, col + 1))
                uf.union(rowcol(row, col), rowcol(row, col + 1));
        }
        if (row == 1)
            uf.union(rowcol(row, col), top);
        if (row == N)
            uf.union(rowcol(row, col), bottom);

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N)
            throw new IllegalArgumentException("Out of bounds");
        return isopen[rowcol(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N)
            throw new IllegalArgumentException("Out of bounds");
        return uf.find(rowcol(row, col)) == uf.find(top);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return noofsites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(top) == uf.find(bottom);
    }
}
