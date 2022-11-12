/*
작성자 : 이혜리
기능 : Command Pattern에서 ConcreteCommand로 실습실 예약 전 실행되는 기능을 구현함.
 */
package cms.ClassSearchPackage;

/**
 *
 * @author 이혜리
 */
public class Concrete_BeforeLab implements Command {

    private final BeforeLab beforelabReceiver;

    public Concrete_BeforeLab(BeforeLab beforelabReceiver) {
        this.beforelabReceiver = beforelabReceiver;
    }

    @Override
    public void exectue() {

        beforelabReceiver.beforeLab();
    }

}
