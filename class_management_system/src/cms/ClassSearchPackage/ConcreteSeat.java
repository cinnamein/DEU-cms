/*
작성자 : 이혜리
기능 : Command Pattern에서 ConcreteCommand로 좌석 조회 기능을 구현함.
 */
package cms.ClassSearchPackage;

import cms.ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 이혜리
 */
public class ConcreteSeat implements Command {

    private final Lab labReceiver;

    public ConcreteSeat(Lab labReceiver) {
        this.labReceiver = labReceiver;
    }

    @Override
    public void exectue() {
        ConnectDB db = new ConnectDB();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select class_num, seat_num from reservation");

            ArrayList class_list = new ArrayList<String>();
            ArrayList seat_list = new ArrayList<String>();

            while (rs.next()) {
                class_list.add(rs.getString("class_num"));
                seat_list.add(rs.getString("seat_num"));
            }

            ClassSearchPage c_search = new ClassSearchPage();

            for (int i = 0; i < class_list.size(); i++) {
                /*
                if (S_ClassSearchPage.final_class.equals(class_list.get(i))) {
                    //System.out.println(rs.getString("seat_num"));
                    System.out.println(S_ClassSearchPage.final_class);
                    System.out.println("좌석");
                 */
                if (c_search.getC_911().equals(class_list.get(i))) {
                    System.out.println("좌석");
                }
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
