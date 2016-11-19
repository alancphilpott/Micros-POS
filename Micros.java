/** Created by Alan on 19/11/2016 */

package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Micros extends JFrame
{
    // Create Local Variables

    private JButton menuButton;  // Buttons For Adding Food
    private JLabel areaLabel; // Label To Name Each Food Item
    private JMenuBar menuBar; // To Create The Menu Bar
    private JMenu fileMenu;
    private JMenu billMenu; // Create The Menus For The Menu Bar
    private JMenuItem menuItem; // Create The Items For The Menus
    private Container cPane; // Container For All J Items
    private Food foodItem = new Food();
    private Drinks drinkItem = new Drinks();
    private String euro = "\u20ac";
    Bill userBill = new Bill();

    public Micros ()
    {
        // Set The JFrame Properties ------------------------------------------------------------------
        super("MicrosSys");
        setSize(230,430);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(800,250);

        // ---------------------------------- Create The Container ----------------------------------
        cPane = getContentPane();
        cPane.setBackground(Color.WHITE);
        cPane.setLayout(null);

        // ---------------------------------- Create The Welcome/Instruction Label ----------------------------------
        areaLabel = new JLabel("Welcome!");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.BLUE);
        areaLabel.setLocation(65,5);
        areaLabel.setSize(200,30);
        cPane.add(areaLabel);
        areaLabel = new JLabel("Choose What You Want");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        areaLabel.setLocation(45,25);
        areaLabel.setSize(200,30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Food Label ----------------------------------
        areaLabel = new JLabel("Food Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.GRAY);
        areaLabel.setLocation(10,50);
        areaLabel.setSize(200,30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Food Buttons ----------------------------------
        menuButton = new JButton(foodItem.getFoodItemOne() + " " + euro + foodItem.getItemOnePrice());
        menuButton.setLocation(10,90);
        menuButton.setSize(200,30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        menuButton = new JButton(foodItem.getFoodItemTwo() + " " + euro + foodItem.getItemTwoPrice());
        menuButton.setLocation(10, 130);
        menuButton.setSize(200,30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        menuButton = new JButton(foodItem.getFoodItemThree() + " " + euro + foodItem.getItemThreePrice());
        menuButton.setLocation(10,170);
        menuButton.setSize(200,30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);

        // ---------------------------------- Create The Drinks Label ----------------------------------
        areaLabel = new JLabel("Drink Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.GRAY);
        areaLabel.setLocation(10,210);
        areaLabel.setSize(200,30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Drink Buttons ----------------------------------
        menuButton = new JButton(drinkItem.getDrinkItemOne() + " " + euro + drinkItem.getItemOnePrice());
        menuButton.setLocation(10,250);
        menuButton.setSize(200,30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        menuButton = new JButton(drinkItem.getDrinkItemTwo() + " " + euro + drinkItem.getItemTwoPrice());
        menuButton.setLocation(10, 290);
        menuButton.setSize(200,30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        menuButton = new JButton(drinkItem.getDrinkItemThree() + " " + euro + drinkItem.getItemThreePrice());
        menuButton.setLocation(10,330);
        menuButton.setSize(200,30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);

        // Create The 'View' Menu To Hold Items
        billMenu = new JMenu("Bill");

        // Create Items To Add To 'View' Menu
        menuItem = new JMenuItem("View Bill"); // New Menu Item Called View
        menuItem.addActionListener(new actionListener()); // Action Listener For When 'View Bill' Is Clicked
        billMenu.add(menuItem); // Add 'View Bill' To The Bill Menu

        menuItem = new JMenuItem("Pay Bill");
        menuItem.addActionListener(new actionListener());
        billMenu.add(menuItem);

        // Create The 'File' Menu To Hold Items
        fileMenu = new JMenu("File");

        //Create Items To Add To 'File' Menu
        menuItem = new JMenuItem("Exit"); // New Menu Item Called Exit
        menuItem.addActionListener(e -> System.exit(0)); // Action Listener For When 'Exit' Is Clicked
        fileMenu.add(menuItem); // Add 'Exit' To The File Menu

        // Create Menu Bar To Add Menus
        menuBar = new JMenuBar();
        menuBar.add(billMenu); menuBar.add(fileMenu);

        // Add The Menu Bar To The Frame
        setJMenuBar(menuBar);
    }

    public class actionListener extends Bill implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            // --------------------------- View Bill Option ---------------------------
            if(a.getActionCommand().equals("View Bill"))
            {
                JOptionPane.showMessageDialog(null,userBill.getBillList());
            }

            // --------------------------- Pay Bill Option ---------------------------
            if(a.getActionCommand().equals("Pay Bill"))
            {
                JOptionPane.showMessageDialog(null, "Your Bill Total Is: " + euro + userBill.getBillTotal());
            }

            // --------------------------- Food Item Number One ---------------------------
            if(a.getActionCommand().equals(foodItem.getFoodItemOne() + " " + euro + foodItem.getItemOnePrice()))
            {
                userBill.setBillList(foodItem.getFoodItemOne());
                userBill.setItemChoosePrice(foodItem.getItemOnePrice());
                JOptionPane.showMessageDialog(null, foodItem.getFoodItemOne() + " Added To Bill");
            }

            // --------------------------- Food Item Number Two ---------------------------
            if(a.getActionCommand().equals(foodItem.getFoodItemTwo() + " " + euro + foodItem.getItemTwoPrice()))
            {
                userBill.setBillList(foodItem.getFoodItemTwo());
                userBill.setItemChoosePrice(foodItem.getItemTwoPrice());
                JOptionPane.showMessageDialog(null, foodItem.getFoodItemTwo() + " Added To Bill");
            }

            // --------------------------- Food Item Number Three ---------------------------
            if(a.getActionCommand().equals(foodItem.getFoodItemThree() + " " + euro + foodItem.getItemThreePrice()))
            {
                userBill.setBillList(foodItem.getFoodItemThree());
                userBill.setItemChoosePrice(foodItem.getItemThreePrice());
                JOptionPane.showMessageDialog(null, foodItem.getFoodItemThree() + " Added To Bill");
            }

            // --------------------------- Drink Item Number One ---------------------------
            if(a.getActionCommand().equals(drinkItem.getDrinkItemOne() + " " + euro + drinkItem.getItemOnePrice()))
            {
                userBill.setBillList(drinkItem.getDrinkItemOne());
                userBill.setItemChoosePrice(drinkItem.getItemOnePrice());
                JOptionPane.showMessageDialog(null, drinkItem.getDrinkItemOne() + " Added To Bill");
            }

            // --------------------------- Drink Item Number Two ---------------------------
            if(a.getActionCommand().equals(drinkItem.getDrinkItemTwo() + " " + euro + drinkItem.getItemTwoPrice()))
            {
                userBill.setBillList(drinkItem.getDrinkItemTwo());
                userBill.setItemChoosePrice(drinkItem.getItemTwoPrice());
                JOptionPane.showMessageDialog(null, drinkItem.getDrinkItemTwo() + " Added To Bill");
            }

            // --------------------------- Drink Item Number Three ---------------------------
            if(a.getActionCommand().equals(drinkItem.getDrinkItemThree() + " " + euro + drinkItem.getItemThreePrice()))
            {
                userBill.setBillList(drinkItem.getDrinkItemThree());
                userBill.setItemChoosePrice(drinkItem.getItemThreePrice());
                JOptionPane.showMessageDialog(null, drinkItem.getDrinkItemThree() + " Added To Bill");
            }
        }
    }
}