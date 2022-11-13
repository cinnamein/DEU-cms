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
public class ResdbUpdate implements ResObserver {

    String name;
    String id;
    int class_num;
    int seat_num;
    String starttime;
    String endtime;
    int admin;
    int approve;
    private ResSubject reservation;

    public ResdbUpdate(ResSubject reservation) {
        this.reservation = reservation;
        reservation.registerObser(this);
    }

    @Override
    public void update(String name, String id, int class_num, int seat_num, String starttime, String endtime, int admin, int approve) {
        //hrow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.name = name;
        this.id = id;
        this.class_num = class_num;
        this.seat_num = seat_num;
        this.starttime = starttime;
        this.endtime = endtime;
        this.admin = admin;
        this.approve = approve;

        display();
    }

    public void display() {

        ConnectDB db = new ConnectDB();
        Connection conn = null;
        PreparedStatement ps = null;

        ReservationPage r = new ReservationPage();
        boolean r_check = r.r_check();

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("insert into Reservation values(?,?,?,?,?,?,?,?)");

            if (r_check) {
                ps.setString(1, name);  // 이름 String
                ps.setString(2, id);    // 아이디 String
                ps.setInt(3, class_num); // 예약할 실습실 번호 int
                ps.setInt(4, seat_num); // 좌석 번호 int
                ps.setString(5, starttime); // 시작시간 date
                ps.setString(6, endtime); // 끝시간 date
                ps.setInt(7, admin); // 관리자 여부 int
                ps.setInt(8, approve); // 승인여부 int

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "예약 되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "이미 예약 되었습니다.");
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
