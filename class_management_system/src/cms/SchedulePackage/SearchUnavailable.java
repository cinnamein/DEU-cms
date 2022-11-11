package cms.SchedulePackage;

import cms.SchedulePackage.SearchState;
import cms.ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
작성자: 정수연
기능: 실습실 상태 조회 불가능
 */
public class SearchUnavailable implements SearchState {
    @Override
    public void search(){
        ConnectDB db = new ConnectDB();  // DB 객체 생성
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("");
            rs = ps.executeQuery();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }
}
