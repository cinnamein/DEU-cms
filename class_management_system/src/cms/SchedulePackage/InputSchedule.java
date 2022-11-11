package cms.SchedulePackage;

import javax.swing.JOptionPane;

import cms.ConnectDB.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.util.Date;

//import java.lang.Date;  //문자열 날짜 값을 클래스로 변환
//SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yy");
//java.util.날짜 udob = sdf1.parse(dob);
//java.sql.Date sqdob = 새로운 java.sql.Date(udob.getTime());
//가입일자(yyyy-mm-dd)
//SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yy");
//          java.util.Date udob = sdf1.parse(dob);
//          java.sql.Date sqdob = new java.sql.Date(udob.getTime());
//          //for date of joining(yyyy-mm-dd)
//          java.sql.Date sqdoj = java.sql.Date.valueOf(doj);
//          //JDBC 연결 객체 생성
//          Class.forName("oracle.jdbc.driver.OracleDriver");
//          Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","local", "test");
//          ////준비된 Statement 객체 생성
//          PreparedStatement ps = con.prepareStatement("insert into person_tab values (?,?,?,?)");
//         // 매개변수에 값을 설정합니다. query
//         
//          ps.setInt(1, id);
//          ps.setString(2, name);
//          ps.setDate(3, sqdob);
//          ps.setDate(4, sqdoj);
//          // 쿼리 실행
//          int res = ps.executeUpdate();   //결과 처리
//          if (res == 0)
//          {
//               System.out.println("레코드가 삽입되지 않았습니다.");
//          }else
//               System.out.println("레코드가 삽입되었습니다.");
//          //jdbc 객체 닫기
//          ps.close();
//          con.close();
//}
/**
 * 담당자: 정수연 
 * 기능: 시간표 등록 기능 구현
 */
public class InputSchedule extends javax.swing.JFrame {

    String grade_num;  //과목번호
    int class_name;  //호실
    String pro_name;  //교수명
    String grade_name;  //과목명
    String start_time;  //시작시간
    String end_time;   //종료시간
    String week_day;   //요일

    public InputSchedule() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        weekDay = new javax.swing.JComboBox<>();
        gradeNum = new javax.swing.JTextField();
        gradeName = new javax.swing.JTextField();
        proName = new javax.swing.JTextField();
        classNum = new javax.swing.JComboBox<>();
        UndoBtn = new javax.swing.JButton();
        OkBtn = new javax.swing.JButton();
        startTime = new javax.swing.JTextField();
        endTime = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("시간표 입력");

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel1.setText("시간표 등록");

        jLabel2.setText("과목번호");

        jLabel3.setText("호실");

        jLabel4.setText("교수명");

        jLabel5.setText("과목명");

        jLabel6.setText("시작시간");

        jLabel7.setText("끝시간");

        jLabel8.setText("요일");

        weekDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일" }));
        weekDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weekDayActionPerformed(evt);
            }
        });

        classNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "911호", "915호", "916호", "918호" }));
        classNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classNumActionPerformed(evt);
            }
        });

        UndoBtn.setText("이전");
        UndoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoBtnActionPerformed(evt);
            }
        });

        OkBtn.setText("등록");
        OkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(classNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(weekDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(gradeNum, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gradeName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(startTime, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(endTime, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(proName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel1)
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UndoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(OkBtn)))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(gradeNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(weekDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(startTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(endTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UndoBtn)
                    .addComponent(OkBtn))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UndoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoBtnActionPerformed
        // 이전 버튼 -> 관리자 메인화면 이동

//        ConnectDB db = new ConnectDB();  // DB 객체 생성
//        Connection conn = null;
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        
//        rs = st.executeQuery("select SUBSTR(id,1,1) from client");  //사용자 유형 찾기
//        
//        switch (rs) {
//            case 'P':  // 교수 - [교수 메인화면] 이동
//                ProfessorMain p = new ProfessorMain();
//                p.setVisible(true);
//                dispose();
//                break;
//            case 'A':   // 조교일 때 [조교 메인화면] 이동
//                AssistantMain e = new AssistantMain();
//                e.setVisible(true);
//                dispose();
//                break;
//        }
//        setVisible(true);
        dispose();
    }//GEN-LAST:event_UndoBtnActionPerformed

    private void OkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtnActionPerformed
        // 시간표 등록 버튼 구현
        // 날짜 컬럼 값 존재하지 않음 - 날짜 JComboBox Unable

        Schedule schedule = new Schedule();  // 세미나 객체 생성

        //ConnectDB db = new ConnectDB();  // DB 객체 생성
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;

        grade_num = gradeNum.getText();
        class_name = (Integer) classNum.getSelectedItem();
        pro_name = proName.getText();
        grade_name = gradeName.getText();
        start_time = startTime.getText();
        end_time = endTime.getText();
        week_day = weekDay.getSelectedItem().toString();//

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = simpleDateFormat.format(start_time);
        String endTime = simpleDateFormat.format(end_time);
        java.sql.Date time1 = java.sql.Date.valueOf(startTime);
        java.sql.Date time2 = java.sql.Date.valueOf(endTime);

        try {
            ConnectDB db = new ConnectDB();
            conn = db.getConnection();
            schedule.notify();
            rs = ps2.executeQuery();

            if (rs.next()) {
                ps2.setString(1, grade_num);
                ps2.setInt(2, class_name);
                ps2.setString(3, pro_name);
                ps2.setString(4, grade_name);
                ps2.setDate(5, time1);  //시작시간
                ps2.setDate(6, time2);  //끝시간
                ps2.setString(7, week_day);  //요일도 date로 값 받을 수 있음
                //8번째 날짜 값을 입력받지 않음

                if (gradeNum.equals("") || gradeName.equals("") || proName.equals("") || classNum.equals("") || weekDay.equals("") || startTime.equals("") || endTime.equals("")) {
                    JOptionPane.showMessageDialog(null, "시간표 정보를 모두 입력해주세요.", "등록 실패", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "시간표 등록이 완료되었습니다.", "등록 완료", JOptionPane.PLAIN_MESSAGE);
                    dispose(); // 프레임 종료
                    ps2.executeUpdate();

                }
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_OkBtnActionPerformed

    private void weekDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekDayActionPerformed
        String[] week = {"월요일","화요일","수요일","목요일","금요일","토요일","일요일"};
        //week = week.
    }//GEN-LAST:event_weekDayActionPerformed


    private void classNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classNumActionPerformed
        // 호실명 콤보박스 선택 이벤트
        Integer[] data = {911, 915, 916, 918};
        //grade_num = (Integer) data.getSelectedItem();
        
    }//GEN-LAST:event_classNumActionPerformed

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
            java.util.logging.Logger.getLogger(InputSchedule.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputSchedule.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputSchedule.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputSchedule.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputSchedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OkBtn;
    private javax.swing.JButton UndoBtn;
    private javax.swing.JComboBox<String> classNum;
    private javax.swing.JTextField endTime;
    private javax.swing.JTextField gradeName;
    private javax.swing.JTextField gradeNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField proName;
    private javax.swing.JTextField startTime;
    private javax.swing.JComboBox<String> weekDay;
    // End of variables declaration//GEN-END:variables
}
