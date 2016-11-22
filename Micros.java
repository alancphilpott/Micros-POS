import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Created by Alan on 19/11/2016 */

class Micros extends JFrame {
    // Create Local Variables

    // Micros Menu
    private final MenuItem[] menu = {
            new MenuItem("Chicken Curry", 10.00, ItemType.FOOD),
            new MenuItem("Spaghetti Bolognese", 15.00, ItemType.FOOD),
            new MenuItem("Steak Sandwich", 20.00, ItemType.FOOD),
            new MenuItem("Lyons Tea", 2.00, ItemType.DRINK),
            new MenuItem("Bewleys Coffee", 3.00, ItemType.DRINK),
            new MenuItem("Hot Chocolate", 4.00, ItemType.DRINK)
    };


    // New Variable Of Type 'Bill'
    private final Bill userBill = new Bill();

    public Micros() {
        // Set The JFrame Properties ------------------------------------------------------------------
        super("MicrosSys");
        setSize(230, 430);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(800, 250);

        // ---------------------------------- Create The Container ----------------------------------
        Container cPane = getContentPane();
        cPane.setBackground(Color.WHITE);
        cPane.setLayout(null);

        // ---------------------------------- Create The Welcome/Instruction Label ----------------------------------
        JLabel areaLabel = new JLabel("Welcome!");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.BLUE);
        areaLabel.setLocation(65, 5);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);
        areaLabel = new JLabel("Choose What You Want");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        areaLabel.setLocation(45, 25);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Food Label ----------------------------------
        areaLabel = new JLabel("Food Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.GRAY);
        areaLabel.setLocation(10, 50);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Food Buttons ----------------------------------
        int distance = 90;
        JButton menuButton;
        for(MenuItem m : menu){
            if(m.getType().equals(ItemType.FOOD)){
                menuButton = new JButton(m.toString());
                menuButton.setLocation(10, distance);
                menuButton.setSize(200, 30);
                menuButton.addActionListener(new actionListener());
                cPane.add(menuButton);
                distance += 40;
            }
        }

        // ---------------------------------- Create The Drinks Label ----------------------------------
        areaLabel = new JLabel("Drink Items");
        areaLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        areaLabel.setForeground(Color.GRAY);
        areaLabel.setLocation(10, 210);
        areaLabel.setSize(200, 30);
        cPane.add(areaLabel);

        // ---------------------------------- Create The Drink Buttons ----------------------------------
        distance = 250;
        for(MenuItem m : menu){
            if(m.getType().equals(ItemType.DRINK)) {
                menuButton = new JButton(m.toString());
                menuButton.setLocation(10, distance);
                menuButton.setSize(200, 30);
                menuButton.addActionListener(new actionListener());
                cPane.add(menuButton);
                distance += 40;
            }
        }

        // Create The 'View' Menu To Hold Items
        JMenu billMenu = new JMenu("Bill");

        // Create Items To Add To 'View' Menu
        JMenuItem menuItem = new JMenuItem("View Bill");
        menuItem.addActionListener(new actionListener()); // Action Listener For When 'View Bill' Is Clicked
        billMenu.add(menuItem); // Add 'View Bill' To The Bill Menu

        menuItem = new JMenuItem("Pay Bill");
        menuItem.addActionListener(new actionListener());
        billMenu.add(menuItem);

        // Create The 'File' Menu To Hold Items
        JMenu fileMenu = new JMenu("File");

        //Create Items To Add To 'File' Menu
        menuItem = new JMenuItem("Exit"); // New Menu Item Called Exit
        menuItem.addActionListener(e -> System.exit(0)); // Action Listener For When 'Exit' Is Clicked
        fileMenu.add(menuItem); // Add 'Exit' To The File Menu

        // Create Menu Bar To Add Menus
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(billMenu);
        menuBar.add(fileMenu);

        // Add The Menu Bar To The Frame
        setJMenuBar(menuBar);
    }

    private class actionListener extends Bill implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            String selected = a.getActionCommand();

            switch (selected) {
                case "View Bill":
                    JOptionPane.showMessageDialog(null, userBill.getBillList());
                    break;

                case "Pay Bill":
                    JOptionPane.showMessageDialog(null, "Your Bill Total Is: €" + userBill.getBillTotal());
                    break;

                default:
                    for (MenuItem m : menu) {
                        if (selected.equals(m.toString())) {
                            userBill.setBill(m);
                            JOptionPane.showMessageDialog(null, m.getName() + " Added To Bill");
                            break;
                        }
                    }
                    break;
            }
        }
    }
}