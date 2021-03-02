package domain;

public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public boolean validate() {
        final int IMPOSSIBLE_DIVISOR = 0;
        if (value == IMPOSSIBLE_DIVISOR) {
            return true;
        }
        return false;
    }

    public int getValue() {
        return value;
    }
}
