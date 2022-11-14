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
public interface SugObserver {
    void update(String name, String content, int suggestionNum);
}
