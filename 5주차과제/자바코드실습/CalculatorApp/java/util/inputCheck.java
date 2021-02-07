package util;

public class inputCheck {
    toInt ti = new toInt();
    public void InputCheck(String in) {
        try {
            ti.to_Int(in);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 문자가 입력되었습니다.");
        }

    }
}
