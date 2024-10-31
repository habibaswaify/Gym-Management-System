package frontend;

import backend.trainer.Member;
import backend.trainer.MemberClassRegistration;
import backend.trainer.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewRegistrations extends JFrame{
    private JTable registrationsTable;
    private JPanel mainPanel;
    public ViewRegistrations(TrainerRole trainerRole){
        setTitle("View Registrations");
        setContentPane(mainPanel);
        setSize(800, 500);
        if(trainerRole.getListOfRegistrations().isEmpty()){
            JOptionPane.showMessageDialog(ViewRegistrations.this,
                    "Error: No registrations to show.",
                    "Display Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        String[] columnNames = {"Member ID","Class ID","Registration Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        for(MemberClassRegistration registration: trainerRole.getListOfRegistrations()){
            String[] rowData = registration.LineRepresentation().split(",");
            model.addRow(rowData);
        }
        registrationsTable.setModel(model);

    }
}
