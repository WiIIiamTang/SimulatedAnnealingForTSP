import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.Collections;

public class TSP
{
    private ArrayList<Attraction> tsp = new ArrayList<>();
    private Park park;
    private double distance;
    private double timeTravelled;
    private double avgSpeed;
    private double clock;

    public TSP(Park park, double avgSpeed)
    {
        this.park = park;
        this.avgSpeed = avgSpeed;

        for (int i = 0; i < park.getSize(); i++)
        {
            this.tsp.add(null);
        }
    }

    public TSP(TSP t, double avgSpeed)
    {
        this.tsp = t.getTsp();
        this.park = t.getPark();
        this.avgSpeed = avgSpeed;
    }

    public Park getPark()
    {
        return this.park;
    }
    public ArrayList<Attraction> getTsp()
    {
        return new ArrayList<>(this.tsp);
    }

    public Attraction getAttract(int i)
    {
        return tsp.get(i);
    }

    public void setAttract(int i, Attraction a)
    {
        tsp.set(i, a);
        distance = 0;
        timeTravelled = 0;
    }

    public int getSize()
    {
        return tsp.size();
    }

    public void generateRoute()
    {
        for (int i= 0; i < this.park.getSize(); i++)
        {
            setAttract(i, this.park.getAttract(i));
        }
        Collections.shuffle(this.tsp);
    }

    public double getDistance()
    {
        if (distance == 0)
        {
            double d = 0;

            for (int i = 0; i < getSize(); i++)
            {
                Attraction current = getAttract(i);
                Attraction next;

                if ( (i+1) < getSize())
                {
                    next = getAttract(i+1);
                }
                else
                {
                    next = getAttract(0);
                }

                d += current.distance(next);
            }
            distance = d;
        }
        return distance;
    }

    public double getTimeTravelled()
    {
        if (distance == 0)
        {
            double d = 0;

            for (int i = 0; i < getSize(); i++)
            {
                Attraction current = getAttract(i);
                Attraction next;

                if ( (i+1) < getSize())
                {
                    next = getAttract(i+1);
                }
                else
                {
                    next = getAttract(0);
                }

                d += current.distance(next);
                timeTravelled += current.getWaitTimes()[(int)clock];

                clock = (clock + ((current.getWaitTimes()[(int)clock]) / 60.));
                clock = (clock + (d / avgSpeed));
                if (clock >= 24)
                {
                    clock = 0.;
                }
            }
            distance = d;
            timeTravelled += d / avgSpeed;
        }

        return timeTravelled;
    }


    public String toString()
    {
        String s = "";

        for (int i = 0; i < getSize(); i++)
        {
            s += getAttract(i) + " | ";
        }
        return s;
    }
}
