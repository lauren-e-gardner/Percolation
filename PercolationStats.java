/* *****************************************************************************
 *  Name:    Lauren Gardner
 *  NetID:   leg3
 *  Precept: P02
 *
 *  Description:  Used to analyze the mean, standard deviation for the
 * percolation of a grid n by n sized.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private static final double CONFIDENCE = 1.96;
    //  ^ value used to calculate low and high confidence
    private int t; // number of trials
    private double[] open; // tracks the open sites among trials

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("0 not valid size");
        Percolation test;
        t = trials;
        open = new double[t];
        for (int i = 0; i < t; i++) {
            test = new Percolation(n);
            while (!test.percolates()) {
                int row = StdRandom.uniform(n);
                int col = StdRandom.uniform(n);
                if (!test.isOpen(row, col))
                    test.open(row, col);
            }
            open[i] = (test.numberOfOpenSites() / ((double) n * n));
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(open);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(open);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return (mean() - ((CONFIDENCE * stddev()) / Math.sqrt(t)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return (mean() + ((CONFIDENCE * stddev()) / Math.sqrt(t)));
    }

    // test client (see below)
    public static void main(String[] args) {
        Stopwatch time = new Stopwatch();
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats test = new PercolationStats(n, trials);
        StdOut.println("mean() = " + test.mean());
        StdOut.println("stddev() = " + test.stddev());
        StdOut.println("confidenceLow() = " + test.confidenceLow());
        StdOut.println("confidenceHigh() = " + test.confidenceHigh());
        StdOut.println("elapsed time = " + time.elapsedTime());

    }

}

