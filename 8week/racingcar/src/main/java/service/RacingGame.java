package service;

import domain.Cars;
import domain.Number;
import utils.RacingGameStatusView;

public class RacingGame {

    private RacingGame() {};

    public static void start() {
        Cars cars = RacingGameController.createCar();
        Number count = RacingGameController.createCount();
        int times = count.getCount();
        while (times-- > 0) {
            cars.moveCars();
            RacingGameStatusView.carStatusView(cars);
            RacingGameStatusView.spacingWord();
        }
        RacingGameStatusView.resultView(cars.getWinner());
    }
}
