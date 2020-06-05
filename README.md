# Simulated Annealing for the TSP


This shows how we are able to come to a decent solution to the traveling salesman problem with simulated annealing. In this version of TSP, nodes have "wait times" and we take into account the speed of the traveler.


GraphResults.java provides some examples to view the results of simulated annealing on the TSP, taking into account possible wait times at the nodes.

In the special case where speed = 1 and all wait times at every node are 0, then this becomes the usual TSP problem where we minimize the distance.
