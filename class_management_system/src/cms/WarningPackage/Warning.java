package cms.WarningPackage;

import java.util.ArrayList;
import java.util.Observer;

/**
 * 작성자: 정수연
 * 기능: 경고 인터페이스 구현
 */
public class Warning implements WarnSubject {
    private ArrayList<Observer> obs = new ArrayList<Observer>();
    public int id;   // 학번
    public int warning; // 경고횟수
    
    private void registerObserver(){
    
    }
    
    private void notifyObserver(){
    
    }
    
    public int getWarning(){
        return warning;
    }
    
    public int getID(){
        return id;
    }
    
    
}
