/*
작성자 : 이혜리
기능 : 로그인 후 학생 페이지
 */
package cms.ClassSearchPackage;

import cms.ConnectDB.ConnectDB;
import cms.UserPackage.LoginPage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 이혜리
 */
public class StudentPage extends javax.swing.JFrame {

    /**
     * Creates new form StudentPage
     */
    public StudentPage() {
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

        searchClass_button = new javax.swing.JButton();
        searchTime_button = new javax.swing.JButton();
        re_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchClass_button.setText("실습실 조회");
        searchClass_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClass_buttonActionPerformed(evt);
            }
        });

        searchTime_button.setText("시간표 조회");
        searchTime_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTime_buttonActionPerformed(evt);
            }
        });

        re_button.setText("실습실 예약");
        re_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                re_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchClass_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTime_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(re_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(searchClass_button)
                .addGap(26, 26, 26)
                .addComponent(searchTime_button)
                .addGap(29, 29, 29)
                .addComponent(re_button)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchClass_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchClass_buttonActionPerformed
        // TODO add your handling code here:
        Lab labReceiver = new Lab();

        Concrete_Lab lab = new Concrete_Lab(labReceiver);

        InVoker button1 = new InVoker(lab);
        button1.pressed();
    }//GEN-LAST:event_searchClass_buttonActionPerformed

    private void searchTime_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTime_buttonActionPerformed
        // TODO add your handling code here:
        TimeTable timeReceiver = new TimeTable();

        Concrete_TimeTable timetable = new Concrete_TimeTable(timeReceiver);

        InVoker button4 = new InVoker(timetable);
        button4.pressed();
    }//GEN-LAST:event_searchTime_buttonActionPerformed

    private void re_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_re_buttonActionPerformed
        // TODO add your handling code here:

        SeatSearchPage re = new SeatSearchPage();
        re.setVisible(true);
    }//GEN-LAST:event_re_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton re_button;
    private javax.swing.JButton searchClass_button;
    private javax.swing.JButton searchTime_button;
    // End of variables declaration//GEN-END:variables
}
