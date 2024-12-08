# Percolation
A JAVA project to implement a simulation to model a percolation system and estimate the percolation threshold using Monte Carlo simulations


## Percolation Simulation and Threshold Estimation
This project implements a simulation to model a percolation system and estimate the percolation threshold using Monte Carlo simulations. Percolation models are commonly used in scientific research to evaluate the flow of substances through porous media, such as water through soil or the electrical conductivity of composite materials.


### Problem Overview
Percolation refers to the movement of a substance (e.g., water) through a medium under the influence of gravity or other forces. In this simulation, we represent the medium as an n×n grid where:

•	Each grid cell (site) can be open (allowing flow) or blocked (restricting flow).\
•	A full site is an open site that is connected to the top row of the grid via a chain of adjacent open sites.\
•	The system percolates if there is a continuous path of full sites from the top row to the bottom row of the grid.

The percolation threshold is the fraction of open sites needed for the system to percolate. The goal of this project is to estimate the percolation threshold through repeated random trials.


### Approach and Methodology
The simulation is implemented using the Weighted Quick Union-Find Algorithm, which efficiently manages connectivity between sites in the grid. The percolation system is evaluated using the following steps:
1.	Grid Representation:\
  o	The n×n grid is represented as a 1D array for computational efficiency.\
  o	Two virtual sites are added: \
    &emsp; 	A virtual top site, connected to all sites in the top row.\
    &emsp; 	A virtual bottom site, connected to all sites in the bottom row.
2.	Site Operations:\
  o	Open: A random blocked site is opened, and its connectivity to adjacent open sites is updated.\
  o	Full: A site is considered full if it is connected to the virtual top site.\
  o	Percolates: The system percolates if the virtual top site is connected to the virtual bottom site.
3.	Monte Carlo Simulation:\
  o	Perform multiple trials of opening random sites until the system percolates.\
  o	Record the fraction of open sites at the moment of percolation for each trial.\
  o	Calculate the mean and standard deviation of the percolation threshold across all trials.
4.	Backwash Prevention:\
  o	To prevent backwash (incorrectly marking sites as full due to connection to the virtual bottom site), a separate union-find structure is used exclusively to determine fullness.


### Key Features
1. Efficient Connectivity Management:\
  &emsp;o	The Weighted Quick Union-Find Algorithm ensures near-logarithmic performance for union and find operations.\
  &emsp;o	Path compression optimizes the data structure for quick lookups.
2. Randomized Trials:\
  &emsp;o	Sites are opened randomly to simulate real-world variability.\
  &emsp;o	Multiple trials ensure statistically robust threshold estimation.
3. Statistical Analysis:\
  &emsp;o	The simulation uses StdStats to compute the mean, standard deviation, and 95% confidence interval for the percolation threshold.


### Libraries and Tools
1. Programming Language: Java
2. Libraries: \
  &emsp; o	edu.princeton.cs.algs4.StdRandom for random number generation.\
 &emsp; o	edu.princeton.cs.algs4.StdStats for statistical calculations.


### Results
The program outputs the following metrics:
1. Mean Percolation Threshold: Average fraction of open sites required for percolation across all trials.
2. Standard Deviation: Variability in the percolation threshold.
3. 95% Confidence Interval: Range within which the true percolation threshold lies with 95% certainty.


### Code and Implementation Details
#### Percolation Class
The Percolation class models the percolation system. It includes methods to open sites, check fullness, count the number of open sites, and determine if the system percolates.
#### PercolationStats Class
The PercolationStats class performs Monte Carlo simulations and calculates statistical metrics for the percolation threshold.


### Conclusion
This project, my assignment as a pert of Bob Sedgewick and Kevin Wayne's Algorithms I, demonstrates the use of union-find algorithms and Monte Carlo simulations to solve a real-world scientific problem efficiently. The implementation is optimized for large grids and provides robust statistical analysis of the percolation threshold.
This repository showcases problem-solving, efficient algorithm design, and the application of statistical methods in computational simulations.



