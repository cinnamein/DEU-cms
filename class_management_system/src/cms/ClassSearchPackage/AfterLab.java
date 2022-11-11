/*
작성자 : 이혜리
기능 : Command Pattern에서 ConcreteCommand로 실습실 예약 후 실행되는 기능을 구현함.
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
public class AfterLab implements Command{
       private final Lab labReceiver;

    public AfterLab(Lab labReceiver) {
        this.labReceiver = labReceiver;
    }

    @Override
    public void exectue() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        LoginPage lg = new LoginPage();

        ConnectDB db = new ConnectDB();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id, class_num, approve from reservation");

            ArrayList<String> id_list = new ArrayList<String>();
            ArrayList<String> class_list = new ArrayList<String>();
            ArrayList<String> a_list = new ArrayList<String>();

            while (rs.next()) {
                id_list.add(rs.getString("id"));
                class_list.add(rs.getString("class_num"));
                a_list.add(rs.getString("approve"));
            }

            int ch = 0;
            int index = 0;    // 예약 여부를 저장하기 위함

            for (int i = 0; i < id_list.size(); i++) {
                if (lg.getID().equals(id_list.get(i))) {
                    
                    if(a_list.get(i).equals("1")){
                        System.out.println(a_list.get(i));
                        labReceiver.afterLab();
                    }
                }
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
