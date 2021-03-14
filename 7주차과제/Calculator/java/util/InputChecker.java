package util;

public class InputChecker {
    IntegerParser integerParser = new IntegerParser();

    public void InputCheck(String in) {
        try {
            integerParser.toInt(in);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 문자가 입력되었습니다.");
        }

    }
}
