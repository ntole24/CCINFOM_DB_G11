import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Controller implements ActionListener, DocumentListener {
    private mainFrame sf;
    
    public Controller(mainFrame sf) {
        this.sf = sf;
        sf.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Confirm_Database": // confirming DB being picked for dFrame
                // Tell the design from the 3rd person pov that they need to update the JLabels based on the selected index
                int chosenDatabaseIndex = sf.getSelectedIndex(0);
                sf.updateDatabaseJLabels(chosenDatabaseIndex);
                break;
            case "Add": // adding a tuple to a selected table  
                boolean validAdd = true;
                // Get the inputs
                String inputsAdd[] = new String[6];
                for (int i = 0; i < 6; i++) {
                    inputsAdd[i] = sf.getInputtedTableValue(i, 0);
                    System.out.println(inputsAdd[i]);
                }

                // Validate them 

                // If valid, add
                if (validAdd) {
                    sf.showPopUp("The values were successfully inputted!", "Info.", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    sf.showPopUp("The values were unsuccessfully inputted.", "Error.", JOptionPane.ERROR_MESSAGE);
                }

                // Close the frame regardless of output
                sf.closeFrame(0);
                break;
            case "Confirm_Transaction":
                int chosenTransactionIndex = sf.getSelectedIndex(1);
                sf.updateTransactionJLabels(chosenTransactionIndex);
                break;
            case "Make": // adding a tuple to a selected table  
                boolean validMake = true;
                // Get the inputs
                String inputsMake[] = new String[4];
                for (int i = 0; i < 4; i++) {
                    inputsMake[i] = sf.getInputtedTableValue(i, 1);
                    System.out.println(inputsMake[i]);
                }

                // Validate them 

                // If valid, add
                if (validMake) {
                    sf.showPopUp("The transaction was successfully made!", "Info.", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    sf.showPopUp("The transaction was unsuccessfully made.", "Error.", JOptionPane.ERROR_MESSAGE);
                }

                // Close the frame regardless of output
                sf.closeFrame(1);
                break;
            case "Confirm_Report":
                int chosenReportIndex = sf.getSelectedIndex(2);
                sf.updateReportJLabels(chosenReportIndex);
                break;
            case "Generate": // adding a tuple to a selected table  
                boolean validGenerate = true;
                // Get the inputs
                String inputsGenerate[] = new String[2];
                for (int i = 0; i < 2; i++) {
                    inputsGenerate[i] = sf.getInputtedTableValue(i, 2);
                    System.out.println(inputsGenerate[i]);
                }

                // Validate them 

                // If valid, add
                if (validGenerate) {
                    sf.showPopUp("The report was successfully generated!", "Info.", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    sf.showPopUp("The reoprt was unsuccessfully generated.", "Error.", JOptionPane.ERROR_MESSAGE);
                }

                // Close the frame regardless of output
                sf.closeFrame(2);
                break;
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertUpdate'");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeUpdate'");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changedUpdate'");
    }
}
