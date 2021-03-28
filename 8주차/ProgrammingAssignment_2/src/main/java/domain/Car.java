package domain;

import utils.RandomUtils;

public class Car implements Move {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int GO_POINT = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void go() {
        if (RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE) >= GO_POINT) {
            position++;
        }
    }
}
