package Project;

/** Created by Alan on 19/11/2016 */

public class Food {

    private String foodItemOne = "Chicken Curry";
    private String foodItemTwo = "Spaghetti Bolognese";
    private String foodItemThree = "Steak Sandwich";
    private double itemOnePrice = 10.00;
    private double itemTwoPrice = 15.00;
    private double itemThreePrice = 20.00;

    public String getFoodItemOne ()
    {
        return foodItemOne;
    }

    public double getItemOnePrice ()
    {
        return itemOnePrice;
    }

    public String getFoodItemTwo ()
    {
        return foodItemTwo;
    }

    public double getItemTwoPrice ()
    {
        return itemTwoPrice;
    }

    public String getFoodItemThree ()
    {
        return foodItemThree;
    }

    public double getItemThreePrice ()
    {
        return itemThreePrice;
    }
}
