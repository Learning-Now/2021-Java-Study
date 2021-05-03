package service;

import domain.Cars;
import domain.Number;
import utils.View;

public class RacingGame {

    private RacingGame() {};

    public static void start() {
        Cars cars = RacingGameController.createCar();
        Number count = RacingGameController.createCount();
        int times = count.getCount();
        while (times-- > 0) {
            cars.moveCars();
            cars.getCars()
                    .stream()
                    .forEach(View::carStatusView);
            View.spacingWord();
        }
        View.resultView(cars.getWinner());
    }
}
