package frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu extends JFrame{
    private JButton trainerRoleButton;
    private JPanel mainMenuPanel;
    private JButton adminRoleButton;

    public mainMenu(){
        setVisible(true);
        setContentPane(mainMenuPanel);
        setTitle("Main Menu");
        setSize(800, 500);
        adminRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminLogin adminLogin = new adminLogin();
                adminLogin.setVisible(true);
                dispose();
            }
        });
        trainerRoleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainerLogin trainerLogin = new trainerLogin();
                trainerLogin.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args){
        mainMenu mainMenu = new mainMenu();
    }
}
