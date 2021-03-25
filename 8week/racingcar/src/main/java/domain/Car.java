package domain;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position;
    private static final int START_NUMBER = 0;
    private static final int FINISH_NUMBER = 10;
    private static final int CONTROL_POINT = 4;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public void movePosition() {
        if (RandomUtils.nextInt(START_NUMBER,FINISH_NUMBER) > CONTROL_POINT) {
            this.position = position + 1;
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }
}
