/* *****************************************************************************
 *  Name:    Lauren Gardner
 *  NetID:   leg3
 *  Precept: P02
 *
 *  Description:  Creates an n by n grid that is fully blocked and can be opened
 * until percolation.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int VIRTUAL_TOP = 0; // virtual top used to check perc.
    private int virtualBottom; // virtual bottom used to check percolation
    private boolean[][] system; // tracks the open and closed slots
    private int num; // number of rows / columns
    private int openSites; // keeps track of open slots
    /** private QuickFindUF grid; **/ // QuickFind code creates grid

    private WeightedQuickUnionUF grid; // Weighted code creates grid

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("0 not valid size");
        else {
            num = n;
            virtualBottom = n * n + 1;
            /** grid = new QuickFindUF(n * n + 2); **/ // QuickFind code
            grid = new WeightedQuickUnionUF(n * n + 2);
            system = new boolean[n][n];
            openSites = 0;
        }
    }

    // method to find the 1D label for a 2D array
    private int gridID(int row, int col) {
        return row * num + col + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if ((row >= num || row < 0) || (col >= num || col < 0))
            throw new IllegalArgumentException(
                    "row / col index " + num + " must be between 0 and " +
                            (num - 1));
        if (!(isOpen(row, col))) {
            system[row][col] = true;
            openSites++;

            // statements to check connection to virtual top & bottom
            if (row == 0)
                grid.union(gridID(row, col), VIRTUAL_TOP);
            if (row == num - 1)
                grid.union(gridID(row, col), virtualBottom);

            // statements to check connection to surrounding points
            if (row != 0 && isOpen(row - 1, col))
                grid.union(gridID(row - 1, col), gridID(row, col));
            if (row < num - 1 && isOpen(row + 1, col))
                grid.union(gridID(row + 1, col), gridID(row, col));
            if (col != 0 && isOpen(row, col - 1))
                grid.union(gridID(row, col - 1), gridID(row, col));
            if (col < num - 1 && isOpen(row, col + 1))
                grid.union(gridID(row, col + 1), gridID(row, col));
        }
    }


    // returns true if the site is not open
    public boolean isOpen(int row, int col) {
        if ((row >= num || row < 0) || (col >= num || col < 0))
            throw new IllegalArgumentException(
                    "row/col index " + row + " or " + col + " must be between "
                            + "0 " + "and " + (num - 1));
        else if (system[row][col])
            return true;
        return false;
    }

    // returns true if site is full (meaning it is connected to a site on row 0)
    public boolean isFull(int row, int col) {
        if ((row >= num || row < 0) || (col >= num || col < 0))
            throw new IllegalArgumentException(
                    "row/col index " + row + " or " + col + " must be between "
                            + "0 " + "and " + (num - 1));
        if ((grid.find(VIRTUAL_TOP) == grid.find(gridID(row, col))))
            return true;
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // returns true if system percolates
    public boolean percolates() {
        if (grid.find(VIRTUAL_TOP) == grid.find(virtualBottom))
            return true;
        return false;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Percolation test1 = new Percolation(5);
        test1.open(0, 1);
        test1.open(1, 1);
        test1.open(2, 1);
        test1.open(3, 1);
        test1.open(4, 1);
        StdOut.println("Is slot (0, 1) open? " + test1.isOpen(0, 1));
        StdOut.println("Is slot (4, 1) open? " + test1.isOpen(4, 1));
        StdOut.println("Is slot (4, 1) connected to the top? " +
                               test1.isFull(4, 1));
        StdOut.println("Does it percolate? " + test1.percolates());
        StdOut.println("How many slots open: " + test1.numberOfOpenSites());
    }
}

