/** Created by Alan on 19/11/2016 */

package Project;

import sun.text.resources.cldr.rn.FormatData_rn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Micros extends JFrame
{
    // Create Local Variables

    private JButton menuButton;  // Buttons For Adding Food
    private JLabel areaLabel; // Label To Name Each Food Item
    private JMenuBar menuBar; // To Create The Menu Bar
    private JMenu fileMenu;
    private JMenu viewMenu; // Create The Menus For The Menu Bar
    private JMenuItem menuItem; // Create The Items For The Menus
    private Container cPane; // Container For All J Items
    private Food foodItem = new Food();
    private Drinks drinkItem = new Drinks();
    private String euro = "\u20ac";

    public Micros ()
    {
        // Set The JFrame Properties ------------------------------------------------------------------
        super("Micros System");
        setSize(230,430);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(50,50);

        // ---------------------------------- Create The Container ----------------------------------
        cPane = getContentPane();
        cPane.setLayout(null);

        // ---------------------------------- Create The Food Label ----------------------------------
        areaLabel = new JLabel("Food Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setLocation(10,10);
        areaLabel.setSize(200,30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Food Buttons ----------------------------------
        menuButton = new JButton(foodItem.getFoodItemOne() + " " + euro + foodItem.getItemOnePrice());
        menuButton.setLocation(10,50);
        menuButton.setSize(200,30);
        cPane.add(menuButton);
        menuButton = new JButton(foodItem.getFoodItemTwo() + " " + euro + foodItem.getItemTwoPrice());
        menuButton.setLocation(10, 90);
        menuButton.setSize(200,30);
        cPane.add(menuButton);
        menuButton = new JButton(foodItem.getFoodItemThree() + " " + euro + foodItem.getItemThreePrice());
        menuButton.setLocation(10,130);
        menuButton.setSize(200,30);
        cPane.add(menuButton);

        // ---------------------------------- Create The Drinks Label ----------------------------------
        areaLabel = new JLabel("Food Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setLocation(10,210);
        areaLabel.setSize(200,30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Drink Buttons ----------------------------------
        menuButton = new JButton(drinkItem.getDrinkItemOne() + " " + euro + drinkItem.getItemOnePrice());
        menuButton.setLocation(10,250);
        menuButton.setSize(200,30);
        cPane.add(menuButton);
        menuButton = new JButton(drinkItem.getDrinkItemTwo() + " " + euro + drinkItem.getItemTwoPrice());
        menuButton.setLocation(10, 290);
        menuButton.setSize(200,30);
        cPane.add(menuButton);
        menuButton = new JButton(drinkItem.getDrinkItemThree() + " " + euro + drinkItem.getItemThreePrice());
        menuButton.setLocation(10,330);
        menuButton.setSize(200,30);
        cPane.add(menuButton);

        // Create The 'File' Menu To Hold Items
        fileMenu = new JMenu("File");

        //Create Items To Add To 'File' Menu
        menuItem = new JMenuItem("Exit"); // New Menu Item Called Exit
        menuItem.addActionListener(e -> System.exit(0)); // Action Listener For When 'Exit' Is Clicked
        fileMenu.add(menuItem); // Add 'Exit' To The File Menu

        // Create The 'View' Menu To Hold Items
        viewMenu = new JMenu("Bill");

        // Create Items To Add To 'View' Menu
        menuItem = new JMenuItem("View Bill"); // New Menu Item Called View
        menuItem.addActionListener(e -> JOptionPane.showMessageDialog(null,"You Choose To: View Bill")); // Action Listener For When 'View Bill' Is Clicked
        viewMenu.add(menuItem); // Add 'View Bill' To The Bill Menu

        // Create Menu Bar To Add Menus
        menuBar = new JMenuBar();
        menuBar.add(fileMenu); menuBar.add(viewMenu);

        // Add The Menu Bar To The Frame
        setJMenuBar(menuBar);
    }

}
