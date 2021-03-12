package domain;

public class Number {

    private final int value;

    public Number(String value) {
        int number = validate(value);
        this.value = number;
    }

    public int validate(String value) {
        try {
            int result = Integer.parseInt(value);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
