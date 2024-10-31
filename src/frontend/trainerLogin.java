package frontend;

import constants.LoginCredentials;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class trainerLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel trainerLoginPanel;
    private final String username;
    private final String password;

    public trainerLogin(){
        setTitle("Trainer Login");
        setContentPane(trainerLoginPanel);
        setSize(800, 500);
        username = LoginCredentials.TRAINER_USERNAME;
        password = LoginCredentials.TRAINER_PASSWORD;

        loginButton.addActionListener(_ -> {
            String enteredUsername = usernameField.getText();
            System.out.println(enteredUsername);
            String enteredPassword = new String(passwordField.getPassword());
            System.out.println(enteredPassword);
            if (!Objects.equals(enteredUsername, username) || !enteredPassword.equals(password)){
                JOptionPane.showMessageDialog(trainerLogin.this, "Wrong username or password");
            }
            else {
                try {
                    TrainerRoleWindow trainerRoleWindow = new TrainerRoleWindow();
                    trainerRoleWindow.setVisible(true);
                    dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
