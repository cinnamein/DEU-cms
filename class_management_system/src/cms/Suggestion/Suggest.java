/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.Suggestion;

import cms.ResCanclePackage.CancleObserver;
import java.util.ArrayList;

/**
 *
 * @author yooun
 */
public class Suggest implements SugSubject{
    private ArrayList observers;
    
    String name;
    String content;
    int suggestionNum;
    
    public Suggest(){
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(SugObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            SugObserver observer = (SugObserver) observers.get(i);
            observer.update(name, content, suggestionNum);
        }
    }
    
    public void setMeasurements(String name, String content, int suggestionNum){
        this.name = name;
        this.content = content;
        this.suggestionNum = suggestionNum;
        
        notifyObserver();
    }
    
    public String getName(){
        return name;
    }
    
    public String getContent(){
        return content;
    }
    
    public int getSuggestionNum(){
        return suggestionNum;
    }
    
}
