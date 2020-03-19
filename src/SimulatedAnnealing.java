public class SimulatedAnnealing
{
    public static int[][] simAnneal(Park p, double speed)
    {
        // initial temperature.
        double temperature = 10000;

        // cooling rate
        double coolRate = 0.001;

        // initial tsp solution
        TSP currentSolution = new TSP(p, speed);
        currentSolution.generateRoute();

        System.out.println("Simulated Annealing: initial solution at " + currentSolution.getTimeTravelled());

        // initial best solution
        TSP bestSolution = new TSP(currentSolution, speed);

        // Main loop. The SA algorithm goes on until the system is cooled down.
        TSP newSolution;
        int attractPos1 = 0;
        int attractPos2 = 0;
        Attraction temp;
        double currentEnergy = 0;
        double newEnergy = 0;

        while (temperature > 1)
        {
            // The new solution is created.
            newSolution = new TSP(currentSolution, speed);

            // Swap two random attractions place in the route.
            attractPos1 = (int) (newSolution.getSize() * Math.random());
            attractPos2 = (int) (newSolution.getSize() * Math.random());

            temp = newSolution.getAttract(attractPos1);
            newSolution.setAttract(attractPos1, newSolution.getAttract(attractPos2));
            newSolution.setAttract(attractPos2, temp);

            // getting energies.
            currentEnergy = currentSolution.getTimeTravelled();
            newEnergy = newSolution.getTimeTravelled();

            if (getAcceptProb(currentEnergy, newEnergy, temperature) > Math.random())
            {
                currentSolution = new TSP(newSolution, speed);
            }

            // updating best solution so far.
            if (currentSolution.getTimeTravelled() < bestSolution.getTimeTravelled())
            {
                bestSolution = new TSP(currentSolution, speed);
            }

            // Printing out current best energy
            //System.out.println("Current best at: " + bestSolution.getDistance());

            temperature = temperature * (1 - coolRate);
        }


        System.out.println("Final solution at " + bestSolution.getTimeTravelled());
        System.out.println("Route: " + bestSolution);

        return coordinatesArray(bestSolution);
    }

    public static int[][] coordinatesArray(TSP t)
    {
        int[][] res = new int[t.getSize()][2];

        for (int i = 0; i < t.getSize(); i++)
        {
            res[i][0] = t.getAttract(i).getX();
            res[i][1] = t.getAttract(i).getY();
        }

        return res;
    }

    public static double getAcceptProb(double currentEnergy, double newEnergy, double temp)
    {
        /* The probability of accepting the new tsp is based on energy (distance) calculated.
        If the new energy is lower, then we accept immediately.
        Else, there is a probability that we accept it. The probability becomes lower the more
        the system cools. */
        if (newEnergy < currentEnergy)
        {
            return 1.0;
        }
        else
        {
            return Math.exp( (currentEnergy - newEnergy) / temp);
        }
    }
}
