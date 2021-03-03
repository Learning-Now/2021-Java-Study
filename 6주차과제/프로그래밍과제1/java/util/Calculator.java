package util;

import input.InputUtils;

public class Calculator {
    private static final int FIRST_INPUT_INDEX = 0;
    private static final int MAKE_OPERAND_INDEX = 1;
    private static final int MAKE_NUMBER_INDEX = 2;

    private int sum;

    private Operator op = new Operator();
    private IntegerParser integerParser = new IntegerParser();
    private InputChecker inputChecker = new InputChecker();

    public void checkFirstInput(String[] sr) {
        inputChecker.InputCheck(sr[FIRST_INPUT_INDEX]);  // 0번째 값이 숫자인지 확인
        sum = integerParser.toInt(sr[FIRST_INPUT_INDEX]);
    }

    public void calculatePlus(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + MAKE_NUMBER_INDEX]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = op.add(sum, integerParser.toInt(sr[i + MAKE_NUMBER_INDEX]));
    }

    public void calculateSubtraction(String[] sr, int i) {

        inputChecker.InputCheck(sr[i + MAKE_NUMBER_INDEX]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = op.sub(sum, integerParser.toInt(sr[i + MAKE_NUMBER_INDEX]));
    }

    public void calculateMultiplication(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + MAKE_NUMBER_INDEX]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = op.multi(sum, integerParser.toInt(sr[i + MAKE_NUMBER_INDEX]));
    }

    public void calculateDivision(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + MAKE_NUMBER_INDEX]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = op.div(sum, integerParser.toInt(sr[i + MAKE_NUMBER_INDEX]));
    }

    public void calculatedByOperator(String[] sr){
        for (int i = FIRST_INPUT_INDEX; i < sr.length - MAKE_NUMBER_INDEX; i += MAKE_NUMBER_INDEX) {
            if (sr[i + MAKE_OPERAND_INDEX].equals("+")) {
                calculatePlus(sr,i);
            }
            if (sr[i + MAKE_OPERAND_INDEX].equals("-")) {
                calculateSubtraction(sr,i);
            }
            if (sr[i + MAKE_OPERAND_INDEX].equals("*")) {
                calculateMultiplication(sr,i);
            }
            if (sr[i + MAKE_OPERAND_INDEX].equals("/")) {
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
        InputUtils in = new InputUtils();
        String inputString = in.getNextLine();

        SplitString sp = new SplitString();
        String[] strResult = sp.splitString(inputString);

        System.out.print("합계 : " + calculate(strResult));
    }
}
