package domain;

public class Number{
    private final int value;

    public Number(String value) {
        int number = validate(value);
        this.value = number;
    }

    private int validate(String value) {
        try {
            int result = Integer.parseInt(value);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

    public int getValue() {
        return value;
    }
}
