package domain;

public class Number {
    private final int value;

    public Number(String buffer) {
        validateNumber(buffer);
        this.value = Integer.parseInt(buffer);
    }

    private void validateNumber(String buffer) {
        try {
            Integer.parseInt(buffer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }

    public int getCount() {
        return value;
    }

}
