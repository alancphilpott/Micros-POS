import javafx.scene.control.Tab;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Created by Alan on 19/11/2016 */

public class Bill {

    private double billTotal;
    private ArrayList<Meal> mealList = new ArrayList<>();

    public void setBill(Meal meal)
    {
        mealList.add(meal);
        billTotal += meal.getPrice();
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
}