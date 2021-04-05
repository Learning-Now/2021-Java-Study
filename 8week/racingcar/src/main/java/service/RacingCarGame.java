package service;

import domain.Cars;
import domain.Number;

public class RacingCarGame {

    public void start() {
        RacingCarGameController controller = new RacingCarGameController();
        Cars cars = controller.createCar();
        Number count = controller.createCount();
        controller.run(cars, count);
    }

}