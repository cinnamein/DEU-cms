/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.Suggestion;

import cms.ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author yooun
 */
public class SugdbUpdate implements SugObserver{
    String name;
    String content;
    int suggestionNum;
    
    public SugSubject suggest;
    
    public SugdbUpdate(SugSubject suggest){
        this.suggest = suggest;
        
        display();
    }
    
    public void display(){
        ConnectDB db = new ConnectDB();
        Connection conn = null;
        PreparedStatement ps = null;

        System.out.println(name);
        System.out.println(suggestionNum);
        System.out.println(content);
        
        try {
            conn = db.getConnection();

            ps = conn.prepareStatement("INSERT INTO SUGGESTION values("+suggestionNum+","+name+","+content+")");

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "불편사항 제보가 완료되었습니다.");

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(String name, String content, int suggestionNum) {
        this.name = name;
        this.content = content;
        this.suggestionNum = suggestionNum;
        display();
    }
}
