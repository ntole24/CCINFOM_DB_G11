// package GUI;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class startFrame {
    private Controller controller; 

    private JFrame frame;
    private JPanel panel;
    private JButton dButton;
    private JButton tButton;
    private JButton rButton;

    private JFrame dFrame;
    private JPanel dPanel;
    private final String[] databaseNames = {"items", "suppliers", "customers", "purchases", "supplier_item_cost", "sales", "jobs", "staff", "payment_details", "payrolls", "returns"};
    private final Integer[] numberOfColsPerDatabase = {5, 6, 5, 5, 3, 5, 3, 3, 4, 3, 5};
    private String[][] columnsPerDatabase = {{"item_id (automatically generated, can leave this blank)", "name", "description", "quantity", "selling_price"}, {"supplier_id (automatically generated, can leave this blank)", "assigned_staff_id", "name", "contact_number", "email", "city"}, {"customer_id (automatically generated, can leave this blank)", "name", "contact_number", "email", "city"}, {"purchase_id (automatically generated, can leave this blank)", "item_id", "purchase_date", "quantity", "expiration_date"}, {"item_id", "supplier_id", "unit_cost"}, {"sale_id (automatically generated, can leave this blank)", "customer_id", "item_id", "quantity", "sale_date"}, {"job_id (automatically generated, can leave this blank)", "job_title", "salary"}, {"staff_id (automatically generated, can leave this blank)", "name", "date_employed", "date_released", "job_id", "status"}, {"payment_id (automatically generated, can leave this blank)", "payment_date", "bonus_penalty", "percentage"}, {"payroll_id (automatically generated, can leave this blank)", "staff_id", "payment_id"}, {"return_id (automatically generated, can leave this blank)", "pharmacist_id", "sale_id", "return_reason", "return_date"}};
    private JComboBox<String> databaseList;
    private int chosenDatabaseIndex;
    private boolean hasDBBeenPicked = false;
    private JButton confirmDatabase;
    JLabel fieldLabels[] = new JLabel[6];
    JTextField textFields[] = new JTextField[6];
    private JButton confirmDBInputs;
    

    private JFrame tFrame;
    private JPanel tPanel;

    private JFrame rFrame;
    private JPanel rPanel;

    private final String[] buttonLabels = {"Edit Database", "Make Transaction", "Generate Reports"};

    private JFrame currentFrame;

    public startFrame() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Welcome to our DB App!");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        panel = new JPanel(new GridLayout(3,0));

        dButton = createButton(0);
        tButton = createButton(1);
        rButton = createButton(2);

        panel.add(dButton);
        panel.add(tButton);
        panel.add(rButton);

        frame.add(panel);
    }

    private void dInitialize() {
        dFrame = new JFrame();
        currentFrame = dFrame;
        dFrame.setTitle("Edit Database");
        dFrame.setSize(800, 500);
        dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dFrame.setLocationRelativeTo(null);
        
        dPanel = new JPanel(new GridLayout(3,0));
        //----//
        JPanel comboBoxAndButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.databaseList = new JComboBox<String>(databaseNames);
        this.confirmDatabase = new JButton("Confirm");
        this.confirmDBInputs = new JButton("Add");
        
        comboBoxAndButton.add(databaseList);
        comboBoxAndButton.add(confirmDatabase);
        dPanel.add(comboBoxAndButton);
        controller = new Controller(this);
        //----//
        
        

        //----//
        JPanel inputFields = new JPanel(new GridLayout(6, 2));

        for (int i = 0; i < 6; i++) {
            if (hasDBBeenPicked) {
                if (i < columnsPerDatabase[chosenDatabaseIndex].length) 
                    fieldLabels[i] = new JLabel(columnsPerDatabase[chosenDatabaseIndex][i]);
                else 
                    fieldLabels[i] = new JLabel("N/A, please leave empty");
            }
            else {
                fieldLabels[i] = new JLabel("Please pick a database first.");
            }
            textFields[i] = new JTextField(10);
            inputFields.add(fieldLabels[i]);
            inputFields.add(textFields[i]);
        }
        dPanel.add(inputFields);

        dPanel.add(confirmDBInputs);

        dFrame.add(dPanel);

        dFrame.setVisible(true);
    }

    private void tInitialize() {
        tFrame = new JFrame();
        currentFrame = tFrame;
        tFrame.setTitle("Make Transactions");
        tFrame.setSize(800, 500);
        tFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tFrame.setLocationRelativeTo(null);
        
        tPanel = new JPanel(new GridLayout(3,0));

        tPanel.add(new JLabel("Transactions"));

        tFrame.add(tPanel);

        tFrame.setVisible(true);
    }

    private void rInitialize() {
        rFrame = new JFrame();
        currentFrame = rFrame;
        rFrame.setTitle("Generate Reports");
        rFrame.setSize(800, 500);
        rFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        rFrame.setLocationRelativeTo(null);
        
        rPanel = new JPanel(new GridLayout(3,0));

        rPanel.add(new JLabel("Reports"));

        rFrame.add(rPanel);

        rFrame.setVisible(true);
    }

    private JButton createButton(int index) {
        JButton button = new JButton(buttonLabels[index]);
        button.setFocusable(false);
        button.setFont(new Font("Arial", Font.PLAIN, 30)); // 30 pixels
        button.setMargin(new Insets(10, 10, 10, 10));

        // Create a button activated action
        button.addActionListener(new ActionListener() {
            // Method that will be executed when someone presses the button
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                switch (index) {
                    case 0: 
                        dInitialize();
                        break;
                    case 1:
                        tInitialize();
                        break;
                    case 2:
                        rInitialize();
                        break;
                }
            }
        });

        button.setEnabled(true);

        button.setPreferredSize(new Dimension(250, 250)); // 200 wide by 75 high

        return button;
    }

    public void show() {
        this.frame.setVisible(true);
    }

    public void updateDatabaseJLabels(int chosenDatabaseIndex) {
        hasDBBeenPicked = true;
        for (int i = 0; i < 6; i++) {
            if (hasDBBeenPicked) {
                if (i < columnsPerDatabase[chosenDatabaseIndex].length) 
                    fieldLabels[i].setText(columnsPerDatabase[chosenDatabaseIndex][i]);
                else 
                    fieldLabels[i].setText("N/A, please leave empty");   
            }
        }
    }

    public void setActionListener(ActionListener al) {
        this.confirmDatabase.addActionListener(al);
        this.confirmDBInputs.addActionListener(al);
    }

    public int getSelectedIndex() {
        return this.databaseList.getSelectedIndex();
    }

    public String getInputtedTableValue(int index) {
        String buffer = textFields[index].getText();
        textFields[index].setText("");

        return buffer;
    }

    public void showPopUp(String message, String header, int messageType) {
        JOptionPane.showMessageDialog(currentFrame, message, header, messageType);
    }

    public void closeFrame(int frame) {
        switch (frame) {
            case 0:
                dFrame.dispose();
                break;
            case 1:
                tFrame.dispose();
                break;
            case 2:
                rFrame.dispose();
                break;
        }
    }
}
