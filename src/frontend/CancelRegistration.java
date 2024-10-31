package frontend;

import backend.general.Utils;
import backend.trainer.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CancelRegistration extends JFrame{
    private JTextField memberIDTextField;
    private JTextField classIDTextField;
    private JButton cancelRegistrationButton;
    private JPanel mainPanel;

    public CancelRegistration(TrainerRole trainerRole){
        setTitle("Cancel Registration");
        setContentPane(mainPanel);
        Utils utilValidations = new Utils();
        setSize(800, 500);

        cancelRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validInput = true;
                String memberID = memberIDTextField.getText();
                String classID = classIDTextField.getText();
                String key = memberID + "-" + classID;
                // Check if memberID exists
                if (memberID.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(CancelRegistration.this,
                            "Error: member ID field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.recordExists(trainerRole.getListOfMembers(), memberID)) {
                    JOptionPane.showMessageDialog(CancelRegistration.this,
                            "Error: Member with ID " + memberID + " does not exist.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;

                }
                // Check if class ID exists
                if (classID.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(CancelRegistration.this,
                            "Error: class ID field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.recordExists(trainerRole.getListOfClasses(), classID)) {
                    JOptionPane.showMessageDialog(CancelRegistration.this,
                            "Error: Class with ID " + classID + " does not exist.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;

                }
                // Check if registration is a duplicate
                else if (!utilValidations.recordExists(trainerRole.getListOfRegistrations(), key)) {
                    JOptionPane.showMessageDialog(CancelRegistration.this,
                            "Error: Registration ID " + key + " does not exist.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                if(validInput){
                    JOptionPane.showMessageDialog(CancelRegistration.this,
                            "Member with ID "+memberID+" has been unregistered from class "+classID+".",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    trainerRole.cancelRegistration(memberID,classID);
                    dispose();
                }
                
            }
        });
    }
}
