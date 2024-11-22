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

public class mainFrame {
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
    private final String[] transactionNames = {"Purchasing of Items", "Selling of Items", "Payroll Distribution", "Processing Returns"};
    private final Integer[] transactionInputsNeeded = {4, 4, 3, 3};
    private final String[][] transactionInputsLabels = {{"Item", "Staff", "Price/Item", "Quantity"},{"Item","Customer","Selling Price/Item","Quantity"},{"Payday Date","Bonus/Deduction? (place None if neither)","Percentage"},{"Sale_ID","Customer_ID","Reason for Return"}};
    private JComboBox<String> transactionList;
    private int chosenTransactionIndex;
    private boolean hasTBeenPicked = false;
    private JButton confirmTransaction;
    JLabel tInputLabels[] = new JLabel[4];
    JTextField tTextFields[] = new JTextField[4];
    private JButton confirmTInputs;

    private JFrame rFrame;
    private JPanel rPanel;
    private final String[] reportNames = {"Item Sales Report", "Inventory Movement Report", "Supplier Purchase Report", "Customer Purchase Report"};
    private final Integer[] reportInputsNeeded = {2, 2, 1, 1};
    private final String[][] reportInputsLabels = {{"Year", "Month"},{"Year","Month"},{"Supplier"},{"Customer","Customer_ID"}};
    private JComboBox<String> reportList;
    private int chosenReportIndex;
    private boolean hasRBeenPicked = false;
    private JButton confirmReport;
    JLabel rInputLabels[] = new JLabel[2];
    JTextField rTextFields[] = new JTextField[2];
    private JButton confirmRInputs;

    private final String[] buttonLabels = {"Edit Database", "Make Transaction", "Generate Reports"};

    private JFrame currentFrame;

    public mainFrame() {
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
        this.confirmDatabase = new JButton("Confirm_Database");
        this.confirmDBInputs = new JButton("Add");
        
        comboBoxAndButton.add(databaseList);
        comboBoxAndButton.add(confirmDatabase);
        dPanel.add(comboBoxAndButton);
        controller = new Controller(this, 0);
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

        JPanel comboBoxAndButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.transactionList = new JComboBox<String>(transactionNames);
        this.confirmTransaction = new JButton("Confirm_Transaction");
        this.confirmTInputs = new JButton("Make");

        comboBoxAndButton.add(transactionList);
        comboBoxAndButton.add(confirmTransaction);
        tPanel.add(comboBoxAndButton);
        controller = new Controller(this, 1);
        //----//
        
        

        //----//
        JPanel inputFields = new JPanel(new GridLayout(4, 2));

        for (int i = 0; i < 4; i++) {
            if (hasTBeenPicked) {
                tInputLabels[i] = new JLabel(transactionInputsLabels[chosenTransactionIndex][i]);
            }
            else
                tInputLabels[i] = new JLabel("Please pick a transaction first.");
            
            tTextFields[i] = new JTextField(20);
            inputFields.add(tInputLabels[i]);
            inputFields.add(tTextFields[i]);
        }
        tPanel.add(inputFields);

        tPanel.add(confirmTInputs);

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

        JPanel comboBoxAndButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.reportList = new JComboBox<String>(reportNames);
        this.confirmReport = new JButton("Confirm_Report");
        this.confirmRInputs = new JButton("Generate");

        comboBoxAndButton.add(reportList);
        comboBoxAndButton.add(confirmReport);
        rPanel.add(comboBoxAndButton);
        controller = new Controller(this, 2);
        //----//
        
        

        //----//
        JPanel inputFields = new JPanel(new GridLayout(4, 2));

        for (int i = 0; i < 2; i++) {
            rInputLabels[i] = new JLabel("Please pick a report first.");
            rTextFields[i] = new JTextField(20);
            inputFields.add(rInputLabels[i]);
            inputFields.add(rTextFields[i]);
        }
        rPanel.add(inputFields);

        rPanel.add(confirmRInputs);

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

    public void updateTransactionJLabels(int chosenTransactionIndex) {
        for (int i = 0; i < 4; i++) {
            if (i < transactionInputsLabels[chosenTransactionIndex].length)
                tInputLabels[i].setText(transactionInputsLabels[chosenTransactionIndex][i]);
            else
                tInputLabels[i].setText("N/A, please leave empty");
        }
    }

    public void updateReportJLabels(int chosenReportIndex) {
        for (int i = 0; i < 2; i++) {
            if (i < reportInputsLabels[chosenReportIndex].length)
                rInputLabels[i].setText(reportInputsLabels[chosenReportIndex][i]);
            else
                rInputLabels[i].setText("N/A, please leave empty");
        }
    }

    public void setActionListener(ActionListener al, int frame) {
        switch (frame) {
            case 0:
                this.confirmDatabase.addActionListener(al);
                this.confirmDBInputs.addActionListener(al);
                break;
            case 1:
                this.confirmTransaction.addActionListener(al);
                this.confirmTInputs.addActionListener(al);
                break;
            case 2:
                this.confirmReport.addActionListener(al);
                this.confirmRInputs.addActionListener(al);
        }
    }

    public int getSelectedIndex(int frame) {
        switch (frame) {
            case 0:
                return this.databaseList.getSelectedIndex();
            case 1:
                return this.transactionList.getSelectedIndex();
            case 2:
                return this.reportList.getSelectedIndex();
        }

        return -1;
    }

    public String getInputtedTableValue(int index, int frame) {
        String buffer = "";

        switch (frame) {
            case 0:
                buffer = (textFields[index].getText().isEmpty()) ? "" : textFields[index].getText();
                textFields[index].setText("");
            case 1:
                buffer = (tTextFields[index].getText().isEmpty()) ? "" : tTextFields[index].getText();
                tTextFields[index].setText("");
            case 2:
                buffer = (rTextFields[index].getText().isEmpty()) ? "" : rTextFields[index].getText();
                rTextFields[index].setText("");
                break;
        }

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
