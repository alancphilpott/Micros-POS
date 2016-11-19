package Project;

import java.util.ArrayList;

/**
 * Created by Alan on 19/11/2016.
 */
public class Bill {

    private double itemChoosePrice;
    private double billTotal;
    private ArrayList<String> billList = new ArrayList<>();

    public void setItemChoosePrice (double itemChoosePrice)
    {
        this.billTotal += itemChoosePrice;
    }

    public void setBillList (String billItem)
    {
        billList.add(billItem);
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
