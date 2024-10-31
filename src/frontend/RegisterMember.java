package frontend;

import backend.general.Utils;
import backend.trainer.Class;
import backend.trainer.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class RegisterMember extends JFrame{
    private JPanel mainPanel;
    private JTextField memberIDTextField;
    private JTextField classIDTextField;
    private JComboBox<LocalDate> dateComboBox;
    private JButton registerButton;

    private void populateDateComboBox(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        setSize(800, 500);

        for (int i = 0; i < 60; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            LocalDate date = LocalDate.now().plusDays(i + 1);
            dateComboBox.addItem(date);
        }

    }
    private boolean classHasSeats(String key, TrainerRole trainerRole){
        for(Class classRecord: trainerRole.getListOfClasses()){
            if(classRecord.getSearchKey().equalsIgnoreCase(key)){
                return classRecord.getAvailableSeats() !=0;
            }
        }
        return false;
    }
    public RegisterMember(TrainerRole trainerRole){
        setTitle("Register Member");
        setContentPane(mainPanel);
        Utils utilValidations = new Utils();
        populateDateComboBox();
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validInput = true;
                String memberID = memberIDTextField.getText();
                String classID = classIDTextField.getText();
                String key = memberID + "-" + classID;
                LocalDate date = (LocalDate) dateComboBox.getSelectedItem();
                // Check if memberID exists
                if (memberID.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(RegisterMember.this,
                            "Error: member ID field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.recordExists(trainerRole.getListOfMembers(), memberID)) {
                    JOptionPane.showMessageDialog(RegisterMember.this,
                            "Error: Member with ID " + memberID + " does not exist.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;

                }
                // Check if class ID exists
                if (classID.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(RegisterMember.this,
                            "Error: class ID field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.recordExists(trainerRole.getListOfClasses(), classID)) {
                    JOptionPane.showMessageDialog(RegisterMember.this,
                            "Error: Class with ID " + classID + " does not exist.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;

                }
                // Check if registration is a duplicate
                else if (utilValidations.recordExists(trainerRole.getListOfRegistrations(), key)) {
                    JOptionPane.showMessageDialog(RegisterMember.this,
                            "Error: Registration ID " + key + " already exists.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                else if(!classHasSeats(classID,trainerRole)){
                   validInput = false;
                    JOptionPane.showMessageDialog(RegisterMember.this,
                            "Error: Class " + classID + " has no available seats.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                if(validInput){
                    JOptionPane.showMessageDialog(RegisterMember.this,
                            "Registration " + key + " was added successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    trainerRole.registerMemberForClass(memberID,classID,date);
                    dispose();
                }

            }
        });
    }
}
