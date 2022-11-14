/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.Suggestion;

/**
 *
 * @author yooun
 */
public interface SugSubject {
    public void registerObserver(SugObserver observer);
    public void notifyObserver();
}
