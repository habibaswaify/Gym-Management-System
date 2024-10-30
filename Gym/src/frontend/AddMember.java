package Gym.src.frontend;

import Gym.src.backend.general.Utils;
import Gym.src.backend.trainer.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember extends JFrame {
    private JTextField IDText;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField membershipText;
    private JTextField phoneNumberText;
    private JTextField statusTextField;
    private JButton addButton;
    private JPanel secondPanel;
    private JPanel mainPanel;

    public AddMember(TrainerRole trainerRole) {
        setTitle("Add Member");
        setContentPane(mainPanel);
        Utils utilValidations = new Utils();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validInput = true;
                String name = nameTextField.getText();
                String ID = IDText.getText();
                String email = emailTextField.getText();
                String membership = membershipText.getText();
                String phoneNumber = phoneNumberText.getText();
                String status = statusTextField.getText();
                // Validate ID
                if (ID.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: ID field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.validateMemberID(ID)) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: invalid ID.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (utilValidations.recordExists(trainerRole.getListOfMembers(), ID)) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: Member with ID " + ID + " already exists",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;

                }
                // Validate name
                if (name.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: name field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.validateName(name)) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: invalid name.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                // Validate email
                if (email.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: email field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                else if (!utilValidations.validateEmail(email)) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: invalid email.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                // Validate membership
                if (membership.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: membership field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                else if (!utilValidations.validateMembership(membership)) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: invalid membership type.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                // Validate phone number
                if (phoneNumber.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: phone number field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                else if (!utilValidations.validatePhoneNumber(phoneNumber)) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: invalid phone number.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                // Validate status
                if (status.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: status field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                else if (!utilValidations.validateStatus(status)) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Error: invalid status.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }

                if (validInput) {
                    JOptionPane.showMessageDialog(AddMember.this,
                            "Member with ID  " + ID + " was added successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    trainerRole.addMember(ID, name, membership, email, phoneNumber, status);
                    dispose();

                }

            }
        });
    }
}
