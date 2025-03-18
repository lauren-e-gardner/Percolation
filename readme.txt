/* *****************************************************************************
 *  Name:     Lauren Gardner
 *  NetID:    leg3
 *  Precept:  P02
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Operating system:  macOS Big Sur 11.2.3
 *  Compiler: JDK 11
 *  Text editor / IDE: IntelliJ IDEA 2020.1.1
 *
 *  Have you taken (part of) this course before: no
 *  Have you taken (part of) the Coursera course Algorithms, Part I or II: no
 *
 *  Hours to complete assignment (optional): ~6
 *
 **************************************************************************** */

Programming Assignment 1: Percolation


/* *****************************************************************************
 *  Describe the data structures (i.e., instance variables) you used to
 *  implement the Percolation API.
 **************************************************************************** */

    VIRTUAL_TOP is a constant used to check percolation. As the program runs
    a portion of the grid unions to it as long as it is in the top row.

    virtualBottom is a variable that is used to check percolation. As the
    program it unions this variable to other groups on the bottom row, this
    variable will also change to be equal with VIRTUAL_TOP once it percolates

    boolean[][] system stores whether a slot has been opened or not

    private int num; stores the number of rows/ cols

    private int openSites tracks the number of opened slots

    private WeightedQuickUnionUF grid is the grid used to employ find and union

/* *****************************************************************************
 *  Briefly describe the algorithms you used to implement each method in
 *  the Percolation API.
 **************************************************************************** */
open(): opens the site if not already open and checks surrounding sites for
possible unions (checks the virtual top, virtual bottom, and in a cross around
site)

isOpen(): Checks if the site is open or not using the system array

isFull(): Checks if the point connects to another open site from the top using
the virtual top and checking if it has the same root as the inputed point

numberOfOpenSites(): returns the openSites variable

percolates(): checks if the virtual top has the same root as the virtual bottom

/* *****************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for various values of n and T when implementing
 *  Percolation.java with QuickFindUF.java (not QuickUnionUF.java). Use a
 *  "doubling" hypothesis, where you successively increase either n or T by
 *  a constant multiplicative factor (not necessarily 2).
 *
 *  To do so, fill in the two tables below. Each table must have 5-10
 *  data points, ranging in time from around 0.25 seconds for the smallest
 *  data point to around 30 seconds for the largest one. Do not include
 *  data points that take less than 0.25 seconds.
 **************************************************************************** */

(keep T constant)
 T = 100
 multiplicative factor (for n) = cuberoot(2) [I multiplied the ratios by 9
                                              because 2^(b/3)]

 n          time (seconds)       ratio         log ratio
--------------------------------------------------------
60          0.28                 N/A             N/A
76          0.728               2.6             4.55
95          1.913               2.63            4.57
120         4.609               2.41            4.44
151         9.054               1.96            4.14
190         28.235              3.12            4.81


(keep n constant)
 n = 100
 multiplicative factor (for T) = 2

 T          time (seconds)       ratio         log ratio
--------------------------------------------------------
12          0.271               N/A             N/A
24          0.513               1.89            0.92
48          1.099               2.14            1.10
96          2.088               1.90            0.93
192         4.624               2.22            1.15
384         6.365               1.38            0.46
768         16.206              2.55            1.35


/* *****************************************************************************
 *  Using the empirical data from the above two tables, give a formula
 *  (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as function of both n and T, such as
 *
 *       ~ 5.3*10^-8 * n^5.0 * T^1.5
 *
 *  Briefly explain how you determined the formula for the running time.
 *  Recall that with tilde notation, you include both the coefficient
 *  and exponents of the leading term (but not lower-order terms).
 *  Use two significant figures for each coefficient and exponent
 *  (e.g., 5.3*10^-8 or 5.0).
 **************************************************************************** */

QuickFindUF running time (in seconds) as a function of n and T:

    ~ 3.5 x 10^-11 * n^4.5 * T^1.0
        I multiplied the ratio of the n trial by 9 to make up for the cuberoot(2).
       I first averaged the log rations from the changing n table to find b.
       Then I did the same to find b for T and then I independently found the
       coreesponding coefficients for n^b and T^b and multiplied them together



/* *****************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 **************************************************************************** */

(keep T constant)
 T = 100
 multiplicative factor (for n) = sqrt(2) [I multiplied the ratios by 4
                                          because 2^(b/2)]

 n          time (seconds)       ratio         log ratio
--------------------------------------------------------
250         0.366               N/A             N/A
354         0.778               2.13            3.09
500         1.518               1.95            2.96
707         3.865               2.55            3.35
1000        10.771              2.79            3.48


(keep n constant)
 n = 100
 multiplicative factor (for T) = 2

 T          time (seconds)       ratio         log ratio
--------------------------------------------------------
450         0.258               N/A             N/A
900         0.345               1.34            0.42
1800        0.945               2.74            1.45
3600        1.817               1.92            0.94
7200        3.464               1.91            0.93


WeightedQuickUnionUF running time (in seconds) as a function of n and T:

    ~ 2.9 x 10^-12 * n^3.2 * T^0.9
        I multiplied the ratio of the n trial by 4 to make up for the sqrt(2).
       I first averaged the log rations from the changing n table to find b.
       Then I did the same to find b for T and then I independently found the
       coreesponding coefficients for n^b and T^b and multiplied them together



/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */




/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */


/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */

I ran into a few problems with run time but then I remembered a discussion from
lecture where to find percolation you should create a virtual top and bottom row
that can be checked once rather than using a for loop that checks multiple
items from the top and bottom lines.

/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */

Before calculating the log2(2^b) to find the b values of the charts that I did
NOT increase by a multiple of 2, I first reset them. For example, if I raised n
or T by a factor of sqrt(2) then after calculating my ratio and before
calculating the log value I would multiply the ratio by 4 since the ratio was
actually 2^(b/2) instead of just 2^b
