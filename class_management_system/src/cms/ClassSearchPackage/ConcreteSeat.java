/*
작성자 : 이혜리
기능 : Command Pattern에서 ConcreteCommand로 좌석 조회 기능을 구현함.
 */
package cms.ClassSearchPackage;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
