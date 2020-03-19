public class Attraction
{
    private String name;
    private int x;
    private int y;
    private int gridSpace;

    //private int[] waitTimes = {0, 0, 2, 4, 6, 10, 12, 8, 6, 5, 2, 0, 0, 0, 2, 4, 6, 10, 12, 8, 6, 5, 2, 0};
    private int[] waitTimes = new int[24]; //default wait times are set to zero

    public Attraction(int gridSpace)
    {
        this.name = "NULL";
        this.gridSpace = gridSpace;
        this.x = (int) (Math.random() * gridSpace);
        this.y = (int) (Math.random() * gridSpace);

    }

    public Attraction(int x, int y, int gridSpace)
    {
        this.name = "NULL";
        this.gridSpace = gridSpace;
        this.x = x;
        this.y = y;
    }

    public Attraction(int x, int y, int gridSpace, int[] waitTimes)
    {
        this.name = "NULL";
        this.gridSpace = gridSpace;
        this.x = x;
        this.y = y;

        for (int i = 0; i < waitTimes.length; i++)
        {
            this.waitTimes[i] = waitTimes[i];
        }
    }

    public Attraction(int x, int y, int gridSpace, String name, int[] waitTimes)
    {
        this.name = name;
        this.gridSpace = gridSpace;
        this.x = x;
        this.y = y;

        for (int i = 0; i < waitTimes.length; i++)
        {
            this.waitTimes[i] = waitTimes[i];
        }
    }

    public Attraction(int x, int y, int gridSpace, String name)
    {
        this.name = name;
        this.gridSpace = gridSpace;
        this.x = x;
        this.y = y;
    }

    public Attraction(int gridSpace, String name)
    {
        this.name = name;
        this.gridSpace = gridSpace;
        this.x = (int) (Math.random() * gridSpace);
        this.y = (int) (Math.random() * gridSpace);
    }

    public int[] getWaitTimes() {return this.waitTimes;}

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public double distance(Attraction a)
    {
        return Math.sqrt(Math.pow(a.getX() - this.x, 2) + Math.pow(a.getY() - this.y, 2));
    }

    public String toString()
    {
        return (this.name + ": " + getX() + "," + getY());
    }
}
