package frontend;

import backend.trainer.Class;
import backend.trainer.TrainerRole;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewClasses extends JFrame{
    private JTable classTable;
    private JPanel mainPanel;
    public ViewClasses(TrainerRole trainerRole){
        setTitle("View Classes");
        setContentPane(mainPanel);
        setSize(800, 500);
        if(trainerRole.getListOfClasses().isEmpty()){
            JOptionPane.showMessageDialog(ViewClasses.this,
                    "Error: No classes to show.",
                    "Display Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        String[] columnNames = {"Class ID","Class Name","Trainer ID","Duration", "Available Seats"};
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        for(Class classRecord: trainerRole.getListOfClasses()){
            String[] rowData = classRecord.LineRepresentation().split(",");
            model.addRow(rowData);
        }
        classTable.setModel(model);
    }
}
