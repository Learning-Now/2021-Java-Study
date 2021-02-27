package domain;

public class Operand {
    private double operand;

    public Operand(String operand) {
        try {
            this.operand = Double.parseDouble(operand);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력하셨습니다.\n" + "잘못 입력된 문자 : " + operand);
        }
    }

    public double getOperand () {
        return this.operand;
    }
}