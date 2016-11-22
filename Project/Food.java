package Project;

/** Created by Alan on 19/11/2016 */

public class Food {

    private String name;
    private double price;

    public Food () {}

    public Food (String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName ()
    {
        return this.name;
    }

    public double getPrice ()
    {
        return this.price;
    }

    public String toString ()
    {
        return String.format("%s - €%.2f", this.getName(),this.getPrice());
    }
}
