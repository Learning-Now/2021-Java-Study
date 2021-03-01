package util;

import input.InputUtils;

public class Calculator {
    private static final int FIRST_NUMBER = 0;
    private static final int OPERAND = 1;
    private static final int NUMBER = 2;

    private int sum;

    private Operator op = new Operator();
    private ToInt ti = new ToInt();
    private InputCheck ic = new InputCheck();

    public void checkFirstInput(String[] sps) {
        ic.InputCheck(sps[FIRST_NUMBER]);  // 0번째 값이 숫자인지 확인
        sum = ti.toInt(sps[FIRST_NUMBER]);
    }

    public void calculatePlus(String[] sps) {
        for (int i = FIRST_NUMBER; i < sps.length - NUMBER; i += NUMBER) {
            ic.InputCheck(sps[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + OPERAND].equals("+")) {   // 1,3,5 등 홀수 번째 인덱스가 연산자와 같을 때
                sum = op.add(sum, ti.toInt(sps[i + NUMBER]));
            }
        }
    }

    public void calculateSubtraction(String[] sps) {
        for (int i = FIRST_NUMBER; i < sps.length - NUMBER; i += NUMBER) {
            ic.InputCheck(sps[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + OPERAND].equals("-")) {
                sum = op.sub(sum, ti.toInt(sps[i + NUMBER]));
            }
        }
    }

    public void calculateMultiplication(String[] sps) {
        for (int i = FIRST_NUMBER; i < sps.length - NUMBER; i += NUMBER) {
            ic.InputCheck(sps[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + OPERAND].equals("*")) {
                sum = op.multi(sum, ti.toInt(sps[i + NUMBER]));
            }
        }
    }

    public void calculateDivision(String[] sps) {
        for (int i = FIRST_NUMBER; i < sps.length - NUMBER; i += NUMBER) {
            ic.InputCheck(sps[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + OPERAND].equals("/")) {
                sum = op.div(sum, ti.toInt(sps[i + NUMBER]));
            }
        }
    }


    public int calculate(String[] sps) {
        //첫번째 값 확인
        checkFirstInput(sps);
        //연산자에 따라 계산
        calculatePlus(sps);
        calculateSubtraction(sps);
        calculateMultiplication(sps);
        calculateDivision(sps);

        return sum;
    }

    public void run() {
        String inputString;
        String[] strResultArray;

        InputUtils in = new InputUtils();
        inputString = in.getNextLine();

        SplitString sp = new SplitString();
        strResultArray = sp.splitString(inputString);

        System.out.println("합계 : " + calculate(strResultArray));
    }
}
