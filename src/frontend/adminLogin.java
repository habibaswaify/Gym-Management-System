package frontend;

import constants.LoginCredentials;

import javax.swing.*;
import java.util.Objects;

public class adminLogin extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel adminLoginPanel;
    private final String username;
    private final String password;

    public adminLogin(){
        setTitle("Admin Logon");
        setSize(800, 500);
        setContentPane(adminLoginPanel);
        username = LoginCredentials.ADMIN_USERNAME;
        password = LoginCredentials.ADMIN_PASSWORD;
        loginButton.addActionListener(_ -> {
            String enteredUsername = usernameField.getText();
            String enteredPassword = new String(passwordField.getPassword());
            if (!Objects.equals(enteredUsername, username) || !enteredPassword.equals(password)){
                JOptionPane.showMessageDialog(adminLogin.this, "Wrong username or password");
            }
            else{
                adminRoleWindow adminRoleWindow = new adminRoleWindow();
                adminRoleWindow.setVisible(true);
                dispose();
            }
        });
    }
}
