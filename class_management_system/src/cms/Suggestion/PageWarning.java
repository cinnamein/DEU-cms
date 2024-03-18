/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.Suggestion;

import cms.ConnectDB.ConnectDB;
import cms.UserPackage.LoginPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author yooun
 */
public class PageWarning extends javax.swing.JFrame {

    /**
     * Creates new form PageWarning
     */
    public PageWarning() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        suggest = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        suggestionTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("불편 사항 제보");

        suggest.setText("제보");
        suggest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suggestActionPerformed(evt);
            }
        });

        cancel.setText("취소");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        suggestionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suggestionTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(suggest, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(suggestionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(suggestionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suggest)
                    .addComponent(cancel))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suggestActionPerformed
        ConnectDB db = new ConnectDB();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String name = "";
        int suggestionNum = 0;
        String content = "";
        LoginPage lg = new LoginPage();
        ArrayList<String> sugArr = new ArrayList<String>();
        
        try {
            conn = db.getConnection();

            //TODO 이 아래부터 안돌아감
            st = conn.prepareStatement("SELECT NAME FROM CLIENT WHERE ID = " + lg.getID() + "'");
            //st = conn.prepareStatement("SELECT NAME FROM CLIENT WHERE ID = '" + lg.getID + "';");
            while (rs.next()) {
                sugArr.add(rs.getString("name"));
            }

            st = conn.prepareStatement("SELECT COUNT (*) FROM SUGGESTION");
            while (rs.next()) {
                sugArr.add(rs.getString("suggestNum"));
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        content = suggest.toString();
        sugArr.add(content);

        Suggest sg = new Suggest();
        SugdbUpdate sdb = new SugdbUpdate(sg);
        sg.setMeasurements(name, content, suggestionNum);
    }//GEN-LAST:event_suggestActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void suggestionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suggestionTextFieldActionPerformed
        String suggestionText = suggestionTextField.getText();
        suggest.setText(suggestionText);
    }//GEN-LAST:event_suggestionTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(PageWarning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageWarning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageWarning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageWarning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageWarning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton suggest;
    private javax.swing.JTextField suggestionTextField;
    // End of variables declaration//GEN-END:variables
}