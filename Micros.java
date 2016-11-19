/** Created by Alan on 19/11/2016 */

package Project;

import javax.swing.*;
import java.awt.*;

public class Micros extends JFrame
{
    private JButton homeButton;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu viewMenu;
    private JMenuItem menuItem;
    private Container cPane;

    public Micros ()
    {
        super("Micros System");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0,0);

    }

}
