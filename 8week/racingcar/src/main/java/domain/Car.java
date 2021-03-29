package domain;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position;
    private static final int START_NUMBER = 0;
    private static final int FINISH_NUMBER = 10;
    private static final int CONTROL_POINT = 4;

    public Car(final String name) {
        validateLength(name);
        validateInput(name);
        this.name = name;
        this.position = 0;
    }

    public void movePosition() {
        if (RandomUtils.randomIntGenerator(START_NUMBER, FINISH_NUMBER) > CONTROL_POINT) {
            this.position = position + 1;
        }
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 5를 넘을수 없습니다.");
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }

    public static void validateInput(String buffer) {
        if (buffer.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }
}
