package Project;

/**
 * Created by Alan on 19/11/2016.
 */
public class Bill {

    private double itemChoosePrice;
    private double billTotal;

    public void setItemChoosePrice (double itemChoosePrice)
    {
        this.billTotal += itemChoosePrice;
    }

    public double getBillTotal ()
    {
        return this.billTotal;
    }
}
