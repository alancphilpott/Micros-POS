
import javax.swing.JTextArea;
import java.awt.Font;
import java.util.ArrayList;

/** Date Created: 19/11/2016.
 * This class is used to create a bill */

public class Bill {

    private static double totalSales; // Keeps track of the total of all sales that took place.
    static double outAmt; // Keeps track of the total outstanding amount to be paid.
    private double billTotal; // Stores the total amount for each bill created.
    private ArrayList<Meal> mealList = new ArrayList<>(); // An ArrayList of type Meal to store all meals added to a Bill.
    private ArrayList<Meal> allMeals = new ArrayList<>(); // An ArrayList of type Meal to store all meals added to every Bill created.

    /**
     * Default Constructor.
     */
    public Bill () { }

    /**
     * Add's a meal to a Meal ArrayList, Increments the total of a Bill, Increments the total of all Bills, Increments the outstanding amount of all Bills.
     * @param meal Meal Type
     */
    public void setBill(Meal meal)
    {
        mealList.add(meal);
        billTotal += meal.getPrice();
        totalSales += meal.getPrice();
        outAmt += meal.getPrice();
    }

    /**
     * Adds's a meal to a Meal ArrayList.
     * @param meal Meal Type
     */
    public void setAllMeals (Meal meal)
    {
        allMeals.add(meal);
    }

    /**
     * This method is used to get the total of all sales.
     * @return The total of all sales that occurred.
     */
    public static double getTotalSales ()
    {
        return totalSales;
    }

    /**
     * This method is used to get the outstanding amount of all unpaid Bills.
     * @return The total outstanding amount in all unpaid Bills.
     */
    public static double getOutAmt ()
    {
        return outAmt;
    }

    /**
     * This method returns the cost of a Bill.
     * @return The total cost of a Bill.
     */
    public double getBillTotal()
    {
        return this.billTotal;
    }

    /**
     * This method returns a Bill with a list of all items on the Bill.
     * @return A JTextArea with a list of all meals on a bill.
     */
    public JTextArea getBillList()
    {
        String billFormat = "";
        JTextArea billArea = new JTextArea();
        billArea.setFont(new Font("monospaced", Font.PLAIN, 14));
        billArea.append(String.format("%-20s %-10s\n\n","Name","Price"));

        for(Meal i : mealList)
        {
            billFormat += String.format("%-20s €%-10s\n",i.getName(), i.getPrice());
            billArea.append(billFormat);
            billFormat = "";
        }

        billArea.append("\nTotal Price: €" + billTotal);
        billArea.setEditable(false);
        return billArea;
    }

    /**
     * This method returns a Bill with a list of all items sold in a session.
     * @return A JTextArea with a list of all meals sold in a session.
     */
    public JTextArea getAllMeals ()
    {
        String billFormat = "";
        JTextArea mealArea = new JTextArea();
        mealArea.setFont(new Font("monospaced", Font.PLAIN, 14));
        mealArea.append(String.format("%-20s %-10s\n\n","Name","Price"));

        for(Meal i : allMeals)
        {
            billFormat += String.format("%-20s €%-10s\n",i.getName(), i.getPrice());
            mealArea.append(billFormat);
            billFormat = "";
        }

        mealArea.append("\nTotal Price: €" + totalSales);
        mealArea.setEditable(false);
        return mealArea;
    }
}