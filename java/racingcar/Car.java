package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int FIRST_DIGIT = 0;
    private static final int LAST_DIGIT = 9;
    private static final int MOVING_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void move() {
        int randomNumber = RandomUtils.nextInt(FIRST_DIGIT, LAST_DIGIT);
        if (randomNumber >= MOVING_NUMBER) {
            position++;
        }
    }


}