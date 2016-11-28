import javafx.scene.control.ListCell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Created by Alan on 19/11/2016 */

public class Micros extends JFrame {
    // Create Local Variables

    // array of tables

    // JItems
    private JButton menuButton;  // Buttons For Adding Food
    private JLabel areaLabel; // Label To Name Each Food Item
    private JComboBox comboBox;
    private JMenuBar menuBar; // To Create The Menu Bar
    private JMenu fileMenu;
    private JMenu billMenu; // Create The Menus For The Menu Bar
    private JMenuItem menuItem; // Create The Items For The Menus
    private JComboBox tableList;
    private Container cPane; // Container For All J Items

    // Micros Menu
    private Meal curry = new Meal("Chicken Curry", 10.00);
    private Meal spaghetti = new Meal("Spaghetti Bolognese", 15.00);
    private Meal steak = new Meal("Steak Sandwich", 20.00);
    private Meal tea = new Meal("Lyons Tea", 2.00);
    private Meal coffee = new Meal("Bewleys Coffee", 3.00);
    private Meal hotchocolate = new Meal("Hot Chocolate", 4.00);

    private Table userTable = new Table();

    private String[] tableNumbers;

    // New Variable Of Type 'Bill'
    private Bill userBill = new Bill();

    public Micros()
    {
        // Set The JFrame Properties ------------------------------------------------------------------
        super("MicrosSys");
        setSize(230, 515);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(800, 250);

        // ---------------------------------- Create The Container ----------------------------------
        cPane = getContentPane();
        cPane.setBackground(Color.WHITE);
        cPane.setLayout(null);

        // ---------------------------------- Create The Welcome/Instruction Label ----------------------------------
        Color red = Color.decode("#ff0000");

        areaLabel = new JLabel("Welcome!");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(red);
        areaLabel.setLocation(65, 5);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);
        areaLabel = new JLabel("Choose A Table Number Then");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        areaLabel.setLocation(30, 30);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);
        areaLabel = new JLabel("Choose What You Want");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        areaLabel.setLocation(45, 50);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);
        areaLabel = new JLabel("- Choose A Table Number -");
        areaLabel.setForeground(red);
        areaLabel.setLocation(35, 80);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);

        // --------------------------------- Create ComboBox for Choosing the Table Number --------------------
        tableList = new JComboBox();
        for(int x = 1; x <= userTable.getNumOfTables(); x++)
        {
            tableList.addItem(String.valueOf(x));
        }

        DefaultListCellRenderer centerText = new DefaultListCellRenderer();
        centerText.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        tableList.setRenderer(centerText);
        tableList.setLocation(10,105);
        tableList.setSize(200,20);
        cPane.add(tableList);

        // ---------------------------------- Create The Food Label ----------------------------------
        areaLabel = new JLabel("Food Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.GRAY);
        areaLabel.setLocation(10, 130);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Food Buttons ----------------------------------
        menuButton = new JButton(curry.toString());
        menuButton.setLocation(10, 170);
        menuButton.setSize(200, 30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        menuButton = new JButton(spaghetti.toString());
        menuButton.setLocation(10, 210);
        menuButton.setSize(200, 30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        menuButton = new JButton(steak.toString());
        menuButton.setLocation(10, 250);
        menuButton.setSize(200, 30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);

        // ---------------------------------- Create The Drinks Label ----------------------------------
        areaLabel = new JLabel("Drink Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.GRAY);
        areaLabel.setLocation(10, 300);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Drink Buttons ----------------------------------
        menuButton = new JButton(tea.toString());
        menuButton.setLocation(10, 340);
        menuButton.setSize(200, 30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        menuButton = new JButton(coffee.toString());
        menuButton.setLocation(10, 380);
        menuButton.setSize(200, 30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        menuButton = new JButton(hotchocolate.toString());
        menuButton.setLocation(10, 420);
        menuButton.setSize(200, 30);
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
        menuBar.add(billMenu);
        menuBar.add(fileMenu);

        // Add The Menu Bar To The Frame
        setJMenuBar(menuBar);
    }

    public class actionListener extends Bill implements ActionListener
    {
        public void actionPerformed(ActionEvent a) {
            // --------------------------- View Bill Option ---------------------------
            if (a.getActionCommand().equals("View Bill")) {
                JOptionPane.showMessageDialog(null, userBill.getBillList());
            }

            // --------------------------- Pay Bill Option ---------------------------
            if (a.getActionCommand().equals("Pay Bill")) {
                JOptionPane.showMessageDialog(null, "Your Bill Total Is: €" + userBill.getBillTotal());
            }

            // --------------------------- Food Item Number One ---------------------------
            if (a.getActionCommand().equals(curry.toString())) {
                userBill.setBill(curry);
                JOptionPane.showMessageDialog(null, curry.getName() + " Added To Bill");
            }

            // --------------------------- Food Item Number Two ---------------------------
            if (a.getActionCommand().equals(spaghetti.toString())) {
                userBill.setBill(spaghetti);
                JOptionPane.showMessageDialog(null, spaghetti.getName() + " Added To Bill");
            }

            // --------------------------- Food Item Number Three ---------------------------
            if (a.getActionCommand().equals(steak.toString())) {
                userBill.setBill(steak);
                JOptionPane.showMessageDialog(null, steak.getName() + " Added To Bill");
            }

            // --------------------------- Drink Item Number One ---------------------------
            if (a.getActionCommand().equals(tea.toString())) {
                userBill.setBill(tea);
                JOptionPane.showMessageDialog(null, tea.getName() + " Added To Bill");
            }

            // --------------------------- Drink Item Number Two ---------------------------
            if (a.getActionCommand().equals(coffee.toString())) {
                userBill.setBill(coffee);
                JOptionPane.showMessageDialog(null, coffee.getName() + " Added To Bill");
            }

            // --------------------------- Drink Item Number Three ---------------------------
            if (a.getActionCommand().equals(hotchocolate.toString())) {
                userBill.setBill(hotchocolate);
                JOptionPane.showMessageDialog(null, hotchocolate.getName() + " Added To Bill");
            }
        }
    }
}