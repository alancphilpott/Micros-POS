import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Created by Alan on 19/11/2016 */

public class Micros extends JFrame {
    // Create Local Variables

    private Bill allMealsSold = new Bill();

    // Create Global JItem Variables
    private JComboBox<String> tableChooser;
    private JLabel totalSalesLabel;
    private JLabel outAmtLabel;
    JMenuItem mealItem;

    //private Array[] of Bill tableNumber;
    private Bill [] allTables = new Bill[10];
    // Micros Menu

    private Meal curry = new Meal("Chicken Curry", 10.00);
    private Meal spaghetti = new Meal("Spaghetti Bolognese", 15.00);
    private Meal steak = new Meal("Steak Sandwich", 20.00);
    private Meal tea = new Meal("Lyons Tea", 2.00);
    private Meal coffee = new Meal("Bewleys Coffee", 3.00);
    private Meal hotChocolate = new Meal("Hot Chocolate", 4.00);

    private double outAmt;

    // Constructor Method
    public Micros()
    {
        // Set The JFrame Properties ------------------------------------------------------------------
        super("MicrosSys");
        setSize(230, 575);
        setResizable(false);
        setLocation(500, 100);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new windowListener());

        // ---------------------------------- Create The Container ----------------------------------
        Container cPane = getContentPane();
        cPane.setBackground(Color.WHITE);
        cPane.setLayout(null);

        // ---------------------------------- Create The Welcome/Instruction Label ----------------------------------
        Color red = Color.decode("#ff0000");

        JLabel areaLabel = new JLabel("Welcome");
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

        tableChooser = new JComboBox<>();
        for(int x = 0; x < allTables.length; x++)
        {
            tableChooser.addItem(String.valueOf(x+1));
        }

        for(int x = 0; x < allTables.length; x++)
        {
            allTables[x] = new Bill();
        }

        DefaultListCellRenderer centerText = new DefaultListCellRenderer();
        centerText.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        tableChooser.setRenderer(centerText);
        tableChooser.setLocation(10,105);
        tableChooser.setSize(200,20);
        cPane.add(tableChooser);

        // ---------------------------------- Create The Food Label ----------------------------------
        areaLabel = new JLabel("Food Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.GRAY);
        areaLabel.setLocation(10, 130);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Food Buttons ----------------------------------
        JButton menuButton = new JButton(curry.toString());
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
        menuButton = new JButton(hotChocolate.toString());
        menuButton.setLocation(10, 420);
        menuButton.setSize(200, 30);
        menuButton.addActionListener(new actionListener());
        cPane.add(menuButton);
        // -----------------------------------------------------------------------------------------------

        /* -------------------------------------------- Create The Menu Bar ------------------------------------------ */
        // Create The 'View' Menu To Hold Items
        JMenu billMenu = new JMenu("Bill");

        // Create Items To Add To 'View' Menu
        JMenuItem menuItem = new JMenuItem("View Bill");
        menuItem.addActionListener(new actionListener()); // Action Listener For When 'View Bill' Is Clicked
        billMenu.add(menuItem); // Add 'View Bill' To The Bill Menu

        menuItem = new JMenuItem("Pay Bill");
        menuItem.addActionListener(new actionListener());
        billMenu.add(menuItem);

        // Create the 'Meal' menu to hold items
        JMenu mealMenu = new JMenu("Meal");

        mealItem = new JMenuItem("View All Meals Sold");
        mealItem.addActionListener(new actionListener());
        mealMenu.add(mealItem);

        mealItem = new JMenuItem("Save File of All Meals Sold Today");
        mealItem.addActionListener(new actionListener());
        mealMenu.add(mealItem);

        // Create The 'File' Menu To Hold Items
        JMenu fileMenu = new JMenu("File");

        //Create Items To Add To 'File' Menu
        menuItem = new JMenuItem("Exit"); // New Menu Item Called Exit
        menuItem.addActionListener(e -> System.exit(0)); // Action Listener For When 'Exit' Is Clicked
        fileMenu.add(menuItem); // Add 'Exit' To The File Menu

        // Create Menu Bar To Add Menus
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.ORANGE);
        menuBar.add(billMenu);
        menuBar.add(mealMenu);
        menuBar.add(fileMenu);

        // Add The Menu Bar To The Frame
        setJMenuBar(menuBar);

        double totalBillSales = Bill.getTotalSales();

        /* Add a reference to total sales on the home screen */
        totalSalesLabel = new JLabel("Total Sales This Session: €" + totalBillSales);
        totalSalesLabel.setLocation(22, 460);
        totalSalesLabel.setSize(200, 30);
        cPane.add(totalSalesLabel);

        /* Add a reference to outstanding bills on the home screen */
        outAmtLabel = new JLabel("Total Amount Outstanding: €" + totalBillSales);
        outAmtLabel.setLocation(20, 480);
        outAmtLabel.setSize(200, 30);
        cPane.add(outAmtLabel);
    }

    public class actionListener extends Bill implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            String tableChosen = tableChooser.getSelectedItem().toString();
            int tableNumber = Integer.parseInt(tableChosen);
            --tableNumber;

            String choice = a.getActionCommand();
            double total = allTables[tableNumber].getBillTotal();

            if(choice.equals("View Bill"))
            {
                if (total == 0) {
                    JOptionPane.showMessageDialog(null,"There Are No Items On The Bill For Table Number: " + (tableNumber+1));
                }
                else {
                    JOptionPane.showMessageDialog(null, allTables[tableNumber].getBillList(), "Table Number " + (tableNumber + 1) + "'s Bill", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if(choice.equals("Pay Bill"))
            {
                String amtAsString;
                double amt;
                if (total != 0) {
                    do {
                        amtAsString = JOptionPane.showInputDialog(null, "Your Bill Total Is: €" + total + " Please Enter Amount You Want To Pay", "Pay Bill For Table Number: " + (tableNumber + 1), JOptionPane.INFORMATION_MESSAGE);
                        amt = Double.parseDouble(amtAsString);
                        double totalRemaining = total;

                        if (amt > total)
                        {
                            outAmt -= total;
                            totalRemaining = 0;
                            total -= amt;
                        }
                        else
                        {
                            outAmt -= amt;
                            totalRemaining -= amt;
                        }

                        if (outAmt < 0)
                        {
                            outAmt = 0;
                        }

                        if (totalRemaining <= 0) {
                            JOptionPane.showMessageDialog(null, "The Bill Has Been Paid. Your Change Is €" + Math.abs(total)); // If negative number, return's the number negated
                            allTables[tableNumber] = new Bill();
                        }
                    } while (total > 0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"There Are No Items On The Bill For Table Number: " + (tableNumber+1));
                }
            }

            if (choice.equals("View All Meals Sold"))
            {
                JOptionPane.showMessageDialog(null, allMealsSold.getAllMeals(), "Table Number " + (tableNumber + 1) + "'s Bill", JOptionPane.INFORMATION_MESSAGE);
            }

            else {
                // --------------------------- Food Item Number One ---------------------------
                if (choice.equals(curry.toString())) {
                    allTables[tableNumber].setBill(curry);
                    allMealsSold.setAllMeals(curry);
                    System.out.println(choice + " Added To Table " + (tableNumber + 1));
                }
                // --------------------------- Food Item Number Two ---------------------------
                if (choice.equals(spaghetti.toString())) {
                    allTables[tableNumber].setBill(spaghetti);
                    allMealsSold.setAllMeals(spaghetti);
                    System.out.println(choice + " Added To Table " + (tableNumber + 1));
                }

                // --------------------------- Food Item Number Three ---------------------------
                if (choice.equals(steak.toString())) {
                    allTables[tableNumber].setBill(steak);
                    allMealsSold.setAllMeals(steak);
                    System.out.println(choice + " Added To Table " + (tableNumber + 1));
                }

                // --------------------------- Drink Item Number One ---------------------------
                if (choice.equals(tea.toString())) {
                    allTables[tableNumber].setBill(tea);
                    allMealsSold.setAllMeals(tea);
                    System.out.println(choice + " Added To Table " + (tableNumber + 1));
                }

                // --------------------------- Drink Item Number Two ---------------------------
                if (choice.equals(coffee.toString())) {
                    allTables[tableNumber].setBill(coffee);
                    allMealsSold.setAllMeals(coffee);
                    System.out.println(choice + " Added To Table " + (tableNumber + 1));
                }

                // --------------------------- Drink Item Number Three ---------------------------
                if (choice.equals(hotChocolate.toString())) {
                    allTables[tableNumber].setBill(hotChocolate);
                    allMealsSold.setAllMeals(hotChocolate);
                    System.out.println(choice + " Added To Table " + (tableNumber + 1));
                }
                totalSalesLabel.setText("Total Sales This Session: €" + getTotalSales());
                outAmtLabel.setText("Total Amount Outstanding: €" + getOutAmt());
            }
        }
    }

    public class windowListener extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            double amtOut = Bill.getOutAmt();

            if(amtOut == 0)
            {
                JOptionPane.showMessageDialog(null,"Total Sales Today: €" + Bill.getTotalSales());
                System.exit(0);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Not All Bills Have Been Paid. Amount Outstanding: €" + amtOut);
            }
        }
    }
}