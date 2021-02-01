package domain;

public class Number {
    private final int value;

    public Number(int value) {
        this.value = value;
        validateNumber();
    }

    private void validateNumber() {
        if(this.value == 0 ){
            throw new IllegalArgumentException("잘못된 값이 들어왔습니다. ");
        }
    }

    public int getValue() {
        return value;
    }
}
