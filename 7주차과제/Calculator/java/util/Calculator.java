package util;

import input.InputUtils;

public class Calculator{
    private OperatorCalculator operatorCalculator = new OperatorCalculator();
    public int calculate(String[] strResult) {
        //첫번째 값 확인
        operatorCalculator.checkFirstInput(strResult);
        //연산자에 따라 계산
        operatorCalculator.calculatedByOperator(strResult);
        return operatorCalculator.getSum();
    }

    public void run() {
        InputUtils in = new InputUtils();
        String inputString = in.getNextLine();

        SplitString sp = new SplitString();
        String[] strResult = sp.splitString(inputString);

        System.out.print("합계 : " + calculate(strResult));
    }
}
