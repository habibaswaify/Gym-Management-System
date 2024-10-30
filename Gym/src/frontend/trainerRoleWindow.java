package Gym.src.frontend;

import Gym.src.backend.trainer.TrainerRole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class trainerRoleWindow extends JFrame{
    private JButton addMemberButton;
    private JButton viewRegistrationsButton;
    private JButton viewMembersButton;
    private JButton addClassButton;
    private JButton viewClassesButton;
    private JButton registerMemberForClassButton;
    private JButton cancelRegistrationButton;
    private JButton logoutButton;
    private JPanel mainPanel;


    public trainerRoleWindow() throws IOException {
        TrainerRole trainerRole = new TrainerRole();
        setTitle("Trainer Role");
        setContentPane(mainPanel);
        setVisible(true);
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMember addMember = new AddMember(trainerRole);
                addMember.setVisible(true);
            }
        });
        viewMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMembers viewMembers = new ViewMembers(trainerRole);
                viewMembers.setVisible(true);

            }
        });
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
    public static void main(String[] args) throws IOException {
        trainerRoleWindow trainerRoleWindow= new trainerRoleWindow();
    }
}
