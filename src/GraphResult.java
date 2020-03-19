import org.math.plot.*;
import org.math.plot.plots.ScatterPlot;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GraphResult
{
    public static void main(String[] args)
    {
        //Park p = createRandomPark(20, 200, "La Ronde");

        double[] waitTime0 = {0, 0, 0, 0, 0, 0, 0, 10, 30, 50, 120, 450, 300, 290, 240, 165, 100, 80, 70, 60, 30, 15, 0, 0};

        Attraction a0 = new Attraction(200, 200, 200, "Plaza", waitTime0);
        Attraction a1 = new Attraction(100,200,200, "Carousel", waitTime0);
        Attraction a2 = new Attraction(0, 150, 200, "Gift Store", waitTime0);
        Attraction a3 = new Attraction(100, 100, 200, "Basketball", waitTime0);
        Attraction a4 = new Attraction(60, 50, 200, "Haunted House", waitTime0);
        Attraction a5 = new Attraction(10, 110, 200, "Ferris Wheel", waitTime0);
        Attraction a6 = new Attraction(150, 20, 200, "Mini Beach", waitTime0);
        Attraction a7 = new Attraction(200, 130, 200, "Restaurant", waitTime0);
        Attraction a8 = new Attraction(170, 150,200, "Fast Food", waitTime0);
        Attraction a9 = new Attraction(120, 70, 200, "Ice Cream", waitTime0);


/*
        Attraction a0 = new Attraction(200, 200, 200, "Plaza");
        Attraction a1 = new Attraction(100,200,200, "Carousel");
        Attraction a2 = new Attraction(0,150, 200, "Roller Coaster");
        Attraction a3 = new Attraction(100, 100, 200, "Basketball");
        Attraction a4 = new Attraction(60, 50, 200, "Haunted House");
        Attraction a5 = new Attraction(10, 110, 200, "Ferris Wheel");
        Attraction a6 = new Attraction(150, 20, 200, "Mini Beach");
        Attraction a7 = new Attraction(200, 130, 200, "Restaurant");
        Attraction a8 = new Attraction(170, 150,200, "Fast Food");
        Attraction a9 = new Attraction(120, 70, 200, "Ice Cream");
*/
        Park p = new Park("La Ronde");
        p.addAttract(a0);
        p.addAttract(a1);
        p.addAttract(a2);
        p.addAttract(a3);
        p.addAttract(a4);
        p.addAttract(a5);
        p.addAttract(a6);
        p.addAttract(a7);
        p.addAttract(a8);
        p.addAttract(a9);

        int[][] results = SimulatedAnnealing.simAnneal(p, 80);

        double[] x = new double[results.length];
        double[] y = new double[results.length];

        double[][] xy = new double[1][2];
        xy[0][0] = results[0][0];
        xy[0][1] = results[0][1];

        for (int i = 0; i < results.length; i++)
        {
            x[i] = results[i][0];
            y[i] = results[i][1];
        }

        Plot2DPanel plot = new Plot2DPanel();
        JFrame frame = new JFrame("TSP Grid");

        plot.addLinePlot("path", x, y);
        plot.addScatterPlot("attractions", Color.red, x,y);
        ScatterPlot s = new ScatterPlot("start", Color.cyan, 0, 10, xy);
        plot.addPlot(s);

        plot.addLegend("South");

        frame.setSize(800, 800);
        frame.setContentPane(plot);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static Park createRandomPark(int numAttractions, int gridSpace, String name)
    {
        Attraction[] a = new Attraction[numAttractions];

        for (int i = 0; i < 20; i++)
        {
            a[i] = new Attraction(gridSpace);
        }

        Park p = new Park(name);

        for (Attraction attraction : a) {
            p.addAttract(attraction);
        }

        return p;
    }

}
