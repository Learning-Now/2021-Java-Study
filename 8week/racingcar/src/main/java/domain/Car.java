package domain;

public class Car implements Comparable<Car> {
    private static final int CONTROL_POINT = 4;
    private static final int MAX_INPUT_LENGTH = 5;
    private final String name;
    private int position;

    public Car(final String name) {
        validateLength(name);
        validateInput(name);
        this.name = name;
        this.position = 0;
    }

    public void movePosition(int randomValue) {
        if (isMoveAble(randomValue)) {
            this.position = position + 1;
        }
    }

    private boolean isMoveAble(int randomValue) {
        return randomValue > CONTROL_POINT;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 5를 넘을수 없습니다.");
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }

    private void validateInput(String buffer) {
        if (buffer.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public boolean isSamePosition(Car other) {
        return other.position == this.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}
