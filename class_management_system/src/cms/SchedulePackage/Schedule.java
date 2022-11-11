package cms.SchedulePackage;

import cms.SchedulePackage.RegisterSchdule;
import cms.ConnectDB.ConnectDB;
import cms.SchedulePackage.InputSchedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 작성자: 정수연
 기능: 시간표 등록
 */
public class Schedule implements RegisterSchdule {
    
    @Override
    public void register(){   
        ConnectDB db = new ConnectDB();  // DB 객체 생성
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        
        try {
            conn = db.getConnection();
            ps1 = conn.prepareStatement("alter session set nls_date_format = 'dd/MON/yyyy hh24:mi:ss");
            ps2 = conn.prepareStatement("insert into schedule values (?,?,?,?,?,?,?,?)");
            //과목번호, 호실, 교수명, 과목명, 시작시간, 끝시간, 요일, 날짜
            //시간표는 날짜값을 받아들이지 않음 -> 날짜 값 null 입력
            rs = ps2.executeQuery();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
    }

    
}
