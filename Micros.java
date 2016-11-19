/** Created by Alan on 19/11/2016 */

package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        fileMenu = new JMenu("File");

        //Create Items To Add To File Menu
        menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(menuItem);

        // Create View Menu
        viewMenu = new JMenu("Bill");

        // Create Items To Add To View Menu

        menuItem = new JMenuItem("View");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"You Choose To: View Bill");
            }
        });
        viewMenu.add(menuItem);

        // Create Menu Bar To Add Menus
        menuBar = new JMenuBar();
        menuBar.add(fileMenu); menuBar.add(viewMenu);

        // Add The Menu Bar To The Frame
        setJMenuBar(menuBar);
    }

}
