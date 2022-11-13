/*
작성자 : 이혜리
기능 : ResObserver를 통해 ResSubjet의 이벤트를 감지하도록 구현함.
 */
package cms.ResStudentPackage;

import cms.ConnectDB.ConnectDB;
import static cms.ResStudentPackage.ReservationPage.end_combobox;
import static cms.ResStudentPackage.ReservationPage.start_combobox;
import cms.UserPackage.LoginPage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 이혜리
 */
public class ResdbUpdate implements ResObserver{
      String name;
    String id;
    int class_num;
    int seat_num;
    String starttime;
    String endtime;
    int admin;
    int approve;

    @Override
    public void update(String name, String id, int class_num, int seat_num, String r_starttime, String r_endtime, int admin, int approve) {
        this.name = name;
        this.id = id;
        this.class_num = class_num;
        this.seat_num = seat_num;
        this.starttime = r_starttime;
        this.endtime = r_endtime;
        this.admin = admin;
        this.approve = approve;

        display();
    }

    public void display() {

        String name = null;
        String seat_Num;
        String starttime;
        String endtime;

        LoginPage lg = new LoginPage();
        ReservationPage  r= new ReservationPage();

        ConnectDB db = new ConnectDB();
        Connection conn = null;
        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        boolean rcheck = r.r_check();

        starttime = start_combobox.getSelectedItem().toString();
        endtime = end_combobox.getSelectedItem().toString();

        try {
            conn = db.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from Client");
            ps = conn.prepareStatement("insert into Reservation values(?,?,?,?,?,?,?,?)");

            ArrayList<String> name_list = new ArrayList<String>();
            ArrayList<String> id_list = new ArrayList<String>();

            while (rs.next()) {
                name_list.add(rs.getString("name"));
                id_list.add(rs.getString("id"));
            }

            if (rcheck) {

                for (int i = 0; i < name_list.size(); i++) {
                    if ((lg.getID().equals(id_list.get(i)))) {
                        name = name_list.get(i);
                    }
                }

                ps.setString(1, name);  // 이름 String
                ps.setString(2, lg.getID());    // 아이디 String
                ps.setInt(3, 911); // 예약할 실습실 번호 int
                ps.setInt(4, 1); // 좌석 번호 int
                ps.setString(5, starttime); // 시작시간 date
                ps.setString(6, endtime); // 끝시간 date
                ps.setInt(7, 0); // 관리자 여부 int
                ps.setInt(8, 0); // 승인여부 int

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "예약 되었습니다.");

            } else {
                JOptionPane.showMessageDialog(null, "이미 예약이 되었습니다.");
            }

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
