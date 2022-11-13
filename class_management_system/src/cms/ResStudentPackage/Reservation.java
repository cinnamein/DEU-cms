/*
작성자 : 이혜리
기능 : 옵저버에 값을 등록하고 변경 값을 알리도록 구현함.
 */
package cms.ResStudentPackage;

import java.util.ArrayList;

/**
 *
 * @author 이혜리
 */
public class Reservation implements ResSubject {

    private ArrayList observers;

    String name;
    String id;
    int class_num;
    int seat_num;
    String starttime;
    String endtime;
    int admin;
    int approve;

    public Reservation() {
        observers = new ArrayList();
    }

    // 옵저버 등록
    @Override
    public void registerObser(ResObserver observer) {
        observers.add(observer);
    }

    // 옵저버에 변경 값 알림
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            ResObserver observer = (ResObserver) observers.get(i);
            observer.update(name, id, class_num, seat_num, starttime, endtime, admin, approve);
        }
    }
}
