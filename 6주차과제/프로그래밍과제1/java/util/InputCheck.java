package util;

public class InputCheck {
    ToInt ti = new ToInt();

    public void InputCheck(String in) {
        try {
            ti.toInt(in);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 문자가 입력되었습니다.");
        }

    }
}
