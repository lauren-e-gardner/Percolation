# Percolation

This project was completed in **Fall 2022** for the **COS226 Algorithms and Data Structures** course. More information can be found here:

https://www.cs.princeton.edu/courses/archive/spring25/cos226/assignments/percolation/specification.php

Percolation describes the behavior of composite systems made of randomly distributed insulating and metallic materials. The key question is: what fraction of the materials need to be metallic for the composite system to become an electrical conductor? Similarly, in a porous landscape with water on the surface (or oil below), under what conditions can the liquid percolate through to the other side?

## The Model
A percolation system is represented as an n-by-n grid of sites, where:

Each site is either open or blocked.

A full site is an open site connected to an open site in the top row through a chain of neighboring open sites (left, right, up, or down).

The system percolates if at least one open site in the bottom row becomes full.

## How to Run the Code

### 1. Compile the Program
Percolation 20x20 grid
```bash
java-algs4 PercolationVisualizer input20.txt
```
Percolation 50x50 grid
```bash
java-algs4 PercolationVisualizer input50.txt
```

