import org.w3c.dom.Attr;

import java.util.ArrayList;

public class Park
{
    private ArrayList<Attraction> parkAttracts;
    private String name;

    public Park(String name)
    {
        this.name = name;
        this.parkAttracts = new ArrayList<Attraction>();
    }

    public void addAttract(Attraction a)
    {
        parkAttracts.add(a);
    }

    public Attraction getAttract(int i)
    {
        return parkAttracts.get(i);
    }

    public int getSize()
    {
        return parkAttracts.size();
    }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<Attraction> getParkAttracts()
    {
       return new ArrayList<Attraction>(this.parkAttracts);
    }

    public String toString()
    {
        return (this.name + ": " + getSize() + " Attractions");
    }


}
