package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE) >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
