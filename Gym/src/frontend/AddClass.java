package Gym.src.frontend;

import Gym.src.backend.general.Utils;
import Gym.src.backend.system.AdminRole;
import Gym.src.backend.trainer.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClass extends JFrame {
    private JTextField IDTextField;
    private JTextField nameTextField;
    private JTextField trainerTextField;
    private JTextField durationTextField;
    private JTextField participantsTextField;
    private JButton addButton;
    private JPanel mainPanel;

    public AddClass(TrainerRole trainerRole, AdminRole adminRole) {
        setTitle("Add Class");
        setContentPane(mainPanel);
        Utils utilValidations = new Utils();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validInput = true;
                String name = nameTextField.getText();
                String classID = IDTextField.getText();
                String trainerID = trainerTextField.getText();
                String duration = durationTextField.getText();
                String participants = participantsTextField.getText();
                int durationInt = 0;
                int participantsInt = 0;
                // Validate ID
                if (classID.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: ID field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.validateClassID(classID)) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: invalid ID.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (utilValidations.recordExists(trainerRole.getListOfClasses(), classID)) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: Class with ID " + classID + " already exists",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;

                }
                // Validate name
                if (name.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: class name field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.validateName(name)) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: invalid class name.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                }
                // Validate trainer ID
                if (trainerID.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: trainer ID field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else if (!utilValidations.recordExists(adminRole.getListOfTrainers(), trainerID)) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: Trainer with ID " + trainerID + " does not exist",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;

                }
                // Validate duration
                if (duration.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: duration field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else {
                    try {
                        durationInt = Integer.parseInt(duration);
                        if (durationInt < 60) {
                            JOptionPane.showMessageDialog(AddClass.this,
                                    "Error: duration should be at least 60 minutes.",
                                    "Input Error",
                                    JOptionPane.ERROR_MESSAGE);
                            validInput = false;

                        }
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(AddClass.this,
                                "Error: invalid duration format. Duration should be an integer.",
                                "Input Error",
                                JOptionPane.ERROR_MESSAGE);
                        validInput = false;

                    }

                }
                // Validate maximum participants
                if (participants.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Error: max participants field is empty.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    validInput = false;
                } else {
                    try {
                        participantsInt = Integer.parseInt(participants);
                        if (participantsInt < 1) {
                            JOptionPane.showMessageDialog(AddClass.this,
                                    "Error: maximum number of participants should be a positive number.",
                                    "Input Error",
                                    JOptionPane.ERROR_MESSAGE);
                            validInput = false;

                        }
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(AddClass.this,
                                "Error: invalid max participants format. Number of participants should be an integer.",
                                "Input Error",
                                JOptionPane.ERROR_MESSAGE);
                        validInput = false;

                    }

                }


                if (validInput) {
                    JOptionPane.showMessageDialog(AddClass.this,
                            "Class with ID  " + classID + " was added successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    trainerRole.addClass(classID, utilValidations.capitalize(name), trainerID, durationInt, participantsInt);
                    dispose();

                }
            }
        });
    }
}
