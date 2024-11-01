/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.frontend;

import com.mycompany.backend.system.AdminRole;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mina
 */
public class AdminRoleWindow extends javax.swing.JFrame {

    /**
     * Creates new form AdminRoleWindow
     */
    AdminRole adminRole;
   
    public AdminRoleWindow() throws IOException {
        initComponents();
        this.adminRole = new AdminRole();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addTrainerButtton = new javax.swing.JButton();
        removeTrainerButton = new javax.swing.JButton();
        viewTrainerButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addTrainerButtton.setBackground(new java.awt.Color(153, 255, 153));
        addTrainerButtton.setText("Add Trainer");
        addTrainerButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrainerButttonActionPerformed(evt);
            }
        });

        removeTrainerButton.setBackground(new java.awt.Color(153, 255, 153));
        removeTrainerButton.setText("Remove Trainer");
        removeTrainerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTrainerButtonActionPerformed(evt);
            }
        });

        viewTrainerButton.setBackground(new java.awt.Color(153, 255, 153));
        viewTrainerButton.setText("View Trainers");
        viewTrainerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTrainerButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(153, 255, 153));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeTrainerButton)
                    .addComponent(addTrainerButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewTrainerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(addTrainerButtton)
                .addGap(18, 18, 18)
                .addComponent(removeTrainerButton)
                .addGap(18, 18, 18)
                .addComponent(viewTrainerButton)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewTrainerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTrainerButtonActionPerformed
        // TODO add your handling code here:
            ViewTrainers viewTrainers = new ViewTrainers(adminRole);
            viewTrainers.setVisible(true);
    }//GEN-LAST:event_viewTrainerButtonActionPerformed

    private void addTrainerButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrainerButttonActionPerformed

            // TODO add your handling code here:
            AddTrainer addTrainer = new AddTrainer(adminRole);
            addTrainer.setVisible(true);
    }//GEN-LAST:event_addTrainerButttonActionPerformed

    private void removeTrainerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTrainerButtonActionPerformed
            RemoveTrainer removeTrainer = new RemoveTrainer(adminRole);
            removeTrainer.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_removeTrainerButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        try {
            // TODO add your handling code here:
            adminRole.logout();
        } catch (IOException ex) {
            Logger.getLogger(AdminRoleWindow.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            dispose();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminRoleWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminRoleWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminRoleWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminRoleWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminRoleWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(AdminRoleWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTrainerButtton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton removeTrainerButton;
    private javax.swing.JButton viewTrainerButton;
    // End of variables declaration//GEN-END:variables
}
