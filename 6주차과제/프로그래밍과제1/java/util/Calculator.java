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

    public void calculatePlus(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = op.add(sum, integerParser.toInt(sr[i + NUMBER]));
    }

    public void calculateSubtraction(String[] sr, int i) {

        inputChecker.InputCheck(sr[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = op.sub(sum, integerParser.toInt(sr[i + NUMBER]));
    }

    public void calculateMultiplication(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = op.multi(sum, integerParser.toInt(sr[i + NUMBER]));
    }

    public void calculateDivision(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + NUMBER]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = op.div(sum, integerParser.toInt(sr[i + NUMBER]));
    }

    public void calculatedByOperator(String[] sr){
        for (int i = FIRST_NUMBER; i < sr.length - NUMBER; i += NUMBER) {
            if (sr[i + OPERAND].equals("+")) {
                calculatePlus(sr,i);
            }
            if (sr[i + OPERAND].equals("-")) {
                calculateSubtraction(sr,i);
            }
            if (sr[i + OPERAND].equals("*")) {
                calculateMultiplication(sr,i);
            }
            if (sr[i + OPERAND].equals("/")) {
                calculateDivision(sr,i);
            }
        }
    }


    public int calculate(String[] sr) {
        //첫번째 값 확인
        checkFirstInput(sr);
        //연산자에 따라 계산
        calculatedByOperator(sr);
        return sum;
    }

    public void run() {
        String inputString;
        String[] strResult;

        InputUtils in = new InputUtils();
        inputString = in.getNextLine();

        SplitString sp = new SplitString();
        strResult = sp.splitString(inputString);

        System.out.print("합계 : " + calculate(strResult));

    }
}
