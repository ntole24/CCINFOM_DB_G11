import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Controller implements ActionListener, DocumentListener {
    private startFrame sf;
    
    public Controller(startFrame sf) {
        this.sf = sf;
        sf.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Confirm": // confirming DB being picked for dFrame
                // Tell the design from the 3rd person pov that they need to update the JLabels based on the selected index
                int chosenDatabaseIndex = sf.getSelectedIndex();
                sf.updateDatabaseJLabels(chosenDatabaseIndex);
                break;
            case "Add": // adding a tuple to a selected table  
                boolean valid = true;
                // Get the inputs
                String inputs[] = new String[6];
                for (int i = 0; i < 6; i++) {
                    inputs[i] = sf.getInputtedTableValue(i);
                }

                // Validate them 

                // If valid, add
                if (valid) {
                    sf.showPopUp("The values were successfully inputted!", "Info.", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    sf.showPopUp("The values were unsuccessfully inputted.", "Error.", JOptionPane.ERROR_MESSAGE);
                }

                // Close the frame regardless of output
                sf.closeFrame(0);
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
