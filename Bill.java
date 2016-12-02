import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Created by Alan on 19/11/2016 */

public class Bill {

    private static double totalSales;
    static double outAmt;
    private double billTotal;
    private ArrayList<Meal> mealList = new ArrayList<>();
    private ArrayList<Meal> allMeals = new ArrayList<>();

    public Bill () { }

    public void setBill(Meal meal)
    {
        mealList.add(meal);
        billTotal += meal.getPrice();
        totalSales += meal.getPrice();
        outAmt += meal.getPrice();
    }

    public void setAllMeals (Meal meal)
    {
        allMeals.add(meal);
    }

    public static double getTotalSales ()
    {
        return totalSales;
    }

    public static double getOutAmt ()
    {
        return outAmt;
    }

    public double getBillTotal()
    {
        return this.billTotal;
    }

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