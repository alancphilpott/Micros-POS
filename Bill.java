package Project;

import java.util.ArrayList;

/**
 * Created by Alan on 19/11/2016.
 */
public class Bill {

    private double item;
    private double billTotal;
    private ArrayList<String> billList = new ArrayList<>();

    public void setBill (String name, double price)
    {
        billList.add(name);
        billTotal += price;
    }

    public double getBillTotal ()
    {
        return this.billTotal;
    }

    public ArrayList<String> getBillList ()
    {
        return billList;
    }
}
