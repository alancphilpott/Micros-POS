package Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Created by Alan on 19/11/2016 */

public class Bill {

    private double item;
    private double billTotal;
    private ArrayList<Meal> billList = new ArrayList<>();

    public void setBill (Meal meal)
    {
        billList.add(meal);
        billTotal += meal.getPrice();
    }

    public double getBillTotal ()
    {
        return this.billTotal;
    }

    public JTextArea getBillList ()
    {
        String billFormat = "";
        JTextArea billArea = new JTextArea();
        billArea.setFont(new Font("monospaced", Font.PLAIN, 14));
        billArea.append(String.format("%-20s %-10s\n\n","Name","Price"));

        for(Meal i : billList) {
            billFormat += String.format("%-20s €%-10s\n",i.getName(), i.getPrice());
            billArea.append(billFormat);
            billFormat = "";
        }

        billArea.append("\nTotal Price: €" + billTotal);
        billArea.setEditable(false);
        return billArea;
    }
}
