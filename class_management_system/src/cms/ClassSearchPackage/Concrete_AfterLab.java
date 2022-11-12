/*
작성자 : 이혜리
기능 : Command Pattern에서 ConcreteCommand로 실습실 예약 후 실행되는 기능을 구현함.
 */
package cms.ClassSearchPackage;


/**
 *
 * @author 이혜리
 */
public class Concrete_AfterLab implements Command {

    private final AfterLab afterlabReceiver;

    public Concrete_AfterLab(AfterLab afterlabReceiver) {
        this.afterlabReceiver = afterlabReceiver;
    }

    @Override
    public void exectue() {

        afterlabReceiver.afterLab();
    }
}
