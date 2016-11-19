package Project;

/** Created by Alan on 19/11/2016 */

public class Drinks {

    private String drinkItemOne = "Lyons Tea";
    private String drinkItemTwo = "Jacobs Coffee";
    private String drinkItemThree = "Hot Chocolate";
    private double itemOnePrice = 2.00;
    private double itemTwoPrice = 3.00;
    private double itemThreePrice = 4.00;
    private String euro = "\u20ac"; // Euro Character

    public String getDrinkItemOne ()
    {
        return drinkItemOne;
    }
    public double getItemOnePrice ()
    {
        return itemOnePrice;
    }

    public String getDrinkItemTwo ()
    {
        return drinkItemTwo;
    }
    public double getItemTwoPrice ()
    {
        return itemTwoPrice;
    }

    public String getDrinkItemThree ()
    {
        return drinkItemThree;
    }
    public double getItemThreePrice ()
    {
        return itemThreePrice;
    }

    public String toString ()
    {
        return drinkItemOne + " " + euro + itemOnePrice + "\n" +
                drinkItemTwo + " " + euro + itemTwoPrice + "\n" +
                drinkItemThree + " " + euro + itemThreePrice;
    }
}
