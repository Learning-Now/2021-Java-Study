package util;

import input.InputUtils;

public class Calculator{
    private OperatorCalculator operatorcalculator = new OperatorCalculator();
    public int calculate(String[] sr) {
        //첫번째 값 확인
        operatorcalculator.checkFirstInput(sr);
        //연산자에 따라 계산
        operatorcalculator.calculatedByOperator(sr);
        return operatorcalculator.getSum();
    }

    public void run() {
        InputUtils in = new InputUtils();
        String inputString = in.getNextLine();

        SplitString sp = new SplitString();
        String[] strResult = sp.splitString(inputString);

        System.out.print("합계 : " + calculate(strResult));
    }
}
