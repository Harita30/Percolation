import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private int trial;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("Out of bounds");
        trial = trials;
        thresholds = new double[trials];
        int row, col, opensites = 0;
        for (int i = 0; i < trial; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                row = StdRandom.uniformInt(1, n + 1);
                col = StdRandom.uniformInt(1, n + 1);

                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                    opensites += 1;
                }
            }
            thresholds[i] = (double) opensites / (n * n);
            opensites = 0;
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(trial));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(trial));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats s = new PercolationStats(n, trials);
        StdOut.println("mean = " + s.mean());
        StdOut.println("stddev = " + s.stddev());
        StdOut.println(
                "95% confidence interval = [" + s.confidenceLo() + ", " + s.confidenceHi() + "]");
    }

}
