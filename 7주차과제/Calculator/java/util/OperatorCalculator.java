package util;

public class OperatorCalculator {
    private static final int FIRST_INPUT_INDEX = 0;
    private static final int MAKE_OPERAND_INDEX = 1;
    private static final int MAKE_NUMBER_INDEX = 2;

    private int sum;

    private Operator operator = new Operator();
    private IntegerParser integerParser = new IntegerParser();
    private InputChecker inputChecker = new InputChecker();

    public void checkFirstInput(String[] sr) {
        inputChecker.InputCheck(sr[FIRST_INPUT_INDEX]);  // 0번째 값이 숫자인지 확인
        sum = integerParser.toInt(sr[FIRST_INPUT_INDEX]);
    }

    public void calculatePlus(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + MAKE_NUMBER_INDEX]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = operator.add(sum, integerParser.toInt(sr[i + MAKE_NUMBER_INDEX]));
    }

    public void calculateSubtraction(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + MAKE_NUMBER_INDEX]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = operator.sub(sum, integerParser.toInt(sr[i + MAKE_NUMBER_INDEX]));
    }

    public void calculateMultiplication(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + MAKE_NUMBER_INDEX]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = operator.multi(sum, integerParser.toInt(sr[i + MAKE_NUMBER_INDEX]));
    }

    public void calculateDivision(String[] sr, int i) {
        inputChecker.InputCheck(sr[i + MAKE_NUMBER_INDEX]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
        sum = operator.div(sum, integerParser.toInt(sr[i + MAKE_NUMBER_INDEX]));
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

    public int getSum(){
        return sum;
    }
}
