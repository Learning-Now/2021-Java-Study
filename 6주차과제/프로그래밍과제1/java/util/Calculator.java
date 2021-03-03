package util;

import input.InputUtils;

public class Calculator {
    private static final int FIRST_NUMBER = 0;
    private static final int OPERAND = 1;
    private static final int NUMBER = 2;

    private int sum;

    private Operator op = new Operator();
    private IntegerParser integerParser = new IntegerParser();
    private InputChecker inputChecker = new InputChecker();

    public void checkFirstInput(String[] sr) {
        inputChecker.InputCheck(sr[FIRST_NUMBER]);  // 0번째 값이 숫자인지 확인
        sum = integerParser.toInt(sr[FIRST_NUMBER]);
    }

    public void calculatePlus(String[] sr) {
        for (int i = FIRST_NUMBER; i < sr.length - NUMBER; i += NUMBER) {
            inputChecker.InputCheck(sr[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sr[i + OPERAND].equals("+")) {   // 1,3,5 등 홀수 번째 인덱스가 연산자와 같을 때
                sum = op.add(sum, integerParser.toInt(sr[i + NUMBER]));
            }
        }
    }

    public void calculateSubtraction(String[] sr) {
        for (int i = FIRST_NUMBER; i < sr.length - NUMBER; i += NUMBER) {
            inputChecker.InputCheck(sr[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sr[i + OPERAND].equals("-")) {
                sum = op.sub(sum, integerParser.toInt(sr[i + NUMBER]));
            }
        }
    }

    public void calculateMultiplication(String[] sr) {
        for (int i = FIRST_NUMBER; i < sr.length - NUMBER; i += NUMBER) {
            inputChecker.InputCheck(sr[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sr[i + OPERAND].equals("*")) {
                sum = op.multi(sum, integerParser.toInt(sr[i + NUMBER]));
            }
        }
    }

    public void calculateDivision(String[] sr) {
        for (int i = FIRST_NUMBER; i < sr.length - NUMBER; i += NUMBER) {
            inputChecker.InputCheck(sr[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sr[i + OPERAND].equals("/")) {
                sum = op.div(sum, integerParser.toInt(sr[i + NUMBER]));
            }
        }
    }


    public int calculate(String[] sr) {
        //첫번째 값 확인
        checkFirstInput(sr);
        //연산자에 따라 계산
        calculatePlus(sr);
        calculateSubtraction(sr);
        calculateMultiplication(sr);
        calculateDivision(sr);

        return sum;
    }

    public void run() {
        String inputString;
        String[] strResult;

        InputUtils in = new InputUtils();
        inputString = in.getNextLine();

        SplitString sp = new SplitString();
        strResult = sp.splitString(inputString);

        System.out.println("합계 : " + calculate(strResult));
    }
}
