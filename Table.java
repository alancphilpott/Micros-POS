/**
 * Created by Alan on 28/11/2016.
 */
public class Table extends Bill {
    private int tableNumber;
    Bill[] bill = new Bill[10];

    public Table ()
    {
        super();
    }

    public void setTableNumber (int tableNumber)
    {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber ()
    {
        return tableNumber;
    }

    public int getNumOfTables ()
    {
        return bill.length;
    }
}
