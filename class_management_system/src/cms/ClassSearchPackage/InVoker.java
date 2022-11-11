/*
작성자 : 이혜리
기능 : Command Pattern에서 Invoker 기능으로 기능 실행을 요청함.
 */
package cms.ClassSearchPackage;

/**
 *
 * @author 이혜리
 */
public class InVoker {

    Command beforeLab;
    Command afterLab;
    Command concreteSeat;

    public void setCommand(Command beforeLab, Command afterLab, Command concreteSeat) {
        this.beforeLab = beforeLab;
        this.afterLab = afterLab;
        this.concreteSeat = concreteSeat;
    }

    public void beforeLab() {
        this.beforeLab.exectue();
    }

    public void afterLab() {
        this.afterLab.exectue();
    }

    public void concreteSeat() {
        this.concreteSeat.exectue();
    }
}
