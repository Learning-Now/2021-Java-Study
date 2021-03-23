package domain;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public void movePosition() {
        if (RandomUtils.nextInt(0,10) > 4) {
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
