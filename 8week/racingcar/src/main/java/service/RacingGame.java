package service;

import domain.Cars;
import domain.Number;
import utils.View;

public class RacingGame {

    private RacingGame() {};

    public static void start() {
        RacingGameController controller = new RacingGameController();
        Cars cars = controller.createCar();
        Number count = controller.createCount();
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
