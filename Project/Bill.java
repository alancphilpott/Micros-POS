package Project;

import javax.swing.*;
import java.util.ArrayList;

/** Created by Alan on 19/11/2016 */

class Bill {

    private double billTotal;
    private final ArrayList<MenuItem> billList = new ArrayList<>();

    public void setBill (MenuItem menuItem)
    {
        billList.add(menuItem);
        billTotal += menuItem.getPrice();
    }

    public double getBillTotal ()
    {
        return this.billTotal;
    }

    public JTextPane getBillList ()
    {
        String html = "<html> <table style=\"width:100%\">\n" +
                "  <tr>\n" +
                "    <th><u>Name</u></th>\n" +
                "    <th><u>Price</u></th>\n" +
                "  </tr>\n";

        for(MenuItem i : billList)
            html += String.format(
                    "  <tr>\n" +
                            "    <td>%s</td>\n" +
                            "    <td>€%s</td>\n" +
                            "  </tr>\n",i.getName(), i.getPrice());

        html += String.format(
                " <tr style=\"border-top: thick double #ff0000;\">\n" +
                        "  <td><b>Total Price</b></td>\n" +
                        "  <td><b>€%.2f</b></td>\n" +
                        " </tr>\n" +
                        "</table></html>;", billTotal);

        JTextPane billArea = new JTextPane();
        billArea.setContentType("text/html");
        billArea.setText(html);
        billArea.setEditable(false);
        return billArea;
    }
}
