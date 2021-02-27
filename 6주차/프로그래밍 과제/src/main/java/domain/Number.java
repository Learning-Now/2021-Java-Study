package domain;

public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public boolean validate() {
        if (value == 0) {
            return false;
        }
        return true;
    }

    public int getValue() {
        return value;
    }
}
