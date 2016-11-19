/** Created by Alan on 19/11/2016 */

package Project;

import javax.swing.*;
import java.awt.*;

public class Micros extends JFrame
{
    // Create Local Variables

    private JButton menuButton;  // Buttons For Adding Food
    private JMenuBar menuBar; // To Create The Menu Bar
    private JMenu fileMenu;
    private JMenu viewMenu; // Create The Menus For The Menu Bar
    private JMenuItem menuItem; // Create The Items For The Menus
    private Container cPane; // Container For All J Items
    private Image foodImage; // For Adding Different Images To The Container

    public Micros ()
    {
        // Set The JFrame Properties
        super("Micros System");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0,0);

        // Create The Container
        cPane = getContentPane();
        cPane.setLayout(new GridBagLayout());

        // Create The Menu To Hold Items

        

    }

}
