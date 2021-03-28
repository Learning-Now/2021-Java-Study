package service;

import domain.Cars;

public class RacingCarGame {

    public void start() {
        RacingCarGameController controller = new RacingCarGameController();
        Cars cars = controller.createCar();
        controller.run(cars);
    }

}
