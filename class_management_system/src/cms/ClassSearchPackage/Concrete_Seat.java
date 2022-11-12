/*
작성자 : 이혜리
기능 : Command Pattern에서 ConcreteCommand로 좌석 조회 기능을 구현함.
 */
package cms.ClassSearchPackage;

import cms.ConnectDB.ConnectDB;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author 이혜리
 */
public class Concrete_Seat implements Command {

    private final Seat seatReceiver;

    public Concrete_Seat(Seat seatReceiver) {
        this.seatReceiver = seatReceiver;
    }

    @Override
    public void exectue() {
        // 1. 선택한 강의실과 DB에 있는 강의실이 일치하는지 확인
        // 2. 일치하면 좌석 확인 및 조회

        ClassSearchPage c_search = new ClassSearchPage();
        
        ConnectDB db = new ConnectDB();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            st = conn.createStatement();

            rs = st.executeQuery(("select seat_num from reservation where class_num='" + c_search.getC_911() + "'"));

            ArrayList seat_list = new ArrayList<String>();

            while (rs.next()) {
                seat_list.add(rs.getString("seat_num"));
            }

            String btn[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"};

            JButton b[] = {SeatSearchPage.btn1, SeatSearchPage.btn2, SeatSearchPage.btn3, SeatSearchPage.btn4, SeatSearchPage.btn5,
                SeatSearchPage.btn6, SeatSearchPage.btn7, SeatSearchPage.btn8, SeatSearchPage.btn9, SeatSearchPage.btn10,
                SeatSearchPage.btn11, SeatSearchPage.btn12, SeatSearchPage.btn13, SeatSearchPage.btn14, SeatSearchPage.btn15,
                SeatSearchPage.btn16, SeatSearchPage.btn17, SeatSearchPage.btn18, SeatSearchPage.btn19, SeatSearchPage.btn20,
                SeatSearchPage.btn21, SeatSearchPage.btn22, SeatSearchPage.btn23, SeatSearchPage.btn24, SeatSearchPage.btn25,
                SeatSearchPage.btn26, SeatSearchPage.btn27, SeatSearchPage.btn28, SeatSearchPage.btn29, SeatSearchPage.btn30,
                SeatSearchPage.btn31, SeatSearchPage.btn32, SeatSearchPage.btn33, SeatSearchPage.btn34, SeatSearchPage.btn35,
                SeatSearchPage.btn36, SeatSearchPage.btn37, SeatSearchPage.btn38, SeatSearchPage.btn39, SeatSearchPage.btn40};

            for (int i = 0; i < seat_list.size(); i++) {
                for (int j = 0; j < btn.length; j++) {
                    if (btn[j].equals(seat_list.get(i))) {
                        System.out.println(btn[j]);
                        b[j].setBackground(Color.gray);

                    }
                }
            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
