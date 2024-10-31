package frontend;

import backend.system.AdminRole;
import backend.trainer.TrainerRole;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TrainerRoleWindow extends JFrame{
    private JButton addMemberButton;
    private JButton viewRegistrationsButton;
    private JButton viewMembersButton;
    private JButton addClassButton;
    private JButton viewClassesButton;
    private JButton registerMemberForClassButton;
    private JButton cancelRegistrationButton;
    private JButton logoutButton;
    private JPanel mainPanel;


    public TrainerRoleWindow() throws IOException {
        TrainerRole trainerRole = new TrainerRole();
        AdminRole adminRole = new AdminRole();// TODO: take admin role as an argument instead of initializing
        setTitle("Trainer Role");
        setContentPane(mainPanel);
        setVisible(true);
        setSize(800, 500);
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMember addMember = new AddMember(trainerRole);
                addMember.setVisible(true);
                dispose();
            }
        });
        viewMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewMembers viewMembers = new ViewMembers(trainerRole);
                viewMembers.setVisible(true);
                dispose();
            }
        });
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            AddClass addClass = new AddClass(trainerRole,adminRole);
            addClass.setVisible(true);
            dispose();
            }
        });

        viewClassesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewClasses viewClasses = new ViewClasses(trainerRole);
                viewClasses.setVisible(true);
                dispose();
            }
        });
        registerMemberForClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterMember registerMember = new RegisterMember(trainerRole);
                registerMember.setVisible(true);
                dispose();
            }
        });
        cancelRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelRegistration cancelRegistration = new CancelRegistration(trainerRole);
                cancelRegistration.setVisible(true);
                dispose();
            }
        });
        viewRegistrationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewRegistrations viewRegistrations = new ViewRegistrations(trainerRole);
                viewRegistrations.setVisible(true);
                dispose();

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    trainerRole.logout();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                finally {
                    dispose();
                }

            }
        });
    }
    public static void main(String[] args) throws IOException {
        TrainerRoleWindow trainerRoleWindow= new TrainerRoleWindow();
    }
}