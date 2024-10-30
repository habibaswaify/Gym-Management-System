package Gym.src.frontend;

import Gym.src.backend.trainer.Member;
import Gym.src.backend.trainer.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewMembers extends JFrame{
    private JPanel mainPanel;
    private JTable membersTable;
    public ViewMembers(TrainerRole trainerRole){
        setTitle("View Members");
        setContentPane(mainPanel);
        if(trainerRole.getListOfMembers().isEmpty()){
            JOptionPane.showMessageDialog(ViewMembers.this,
                    "Error: No members to show.",
                    "Display Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        String[] columnNames = {"ID","Name","Membership Type","Email", "Phone Number", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        for(Member member: trainerRole.getListOfMembers()){
            String[] rowData = member.LineRepresentation().split(",");
            model.addRow(rowData);
        }
        membersTable.setModel(model);

    }

}
