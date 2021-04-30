package domain;

public class Number {
    private final int value;

    public Number(String value) {
        validateNumber(value);
        this.value = Integer.parseInt(value);
    }

    private void validateNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

    public int getCount() {
        return value;
    }
}
