package Gym.src.frontend;

import Gym.src.backend.trainer.Member;
import Gym.src.backend.trainer.MemberClassRegistration;
import Gym.src.backend.trainer.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewRegistrations extends JFrame{
    private JTable registrationsTable;
    private JPanel mainPanel;
    public ViewRegistrations(TrainerRole trainerRole){
        setTitle("View Registrations");
        setContentPane(mainPanel);
        if(trainerRole.getListOfRegistrations().isEmpty()){
            JOptionPane.showMessageDialog(ViewRegistrations.this,
                    "Error: No registrations to show.",
                    "Display Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        String[] columnNames = {"Member ID","Class ID","Registration Date"};
        DefaultTableModel model = new DefaultTableModel(0, 3);
        model.setColumnIdentifiers(columnNames);
        for(MemberClassRegistration registration: trainerRole.getListOfRegistrations()){
            String[] rowData = registration.LineRepresentation().split(",");
            model.addRow(rowData);
        }
        registrationsTable.setModel(model);

    }
}
