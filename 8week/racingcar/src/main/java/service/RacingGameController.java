package service;

import domain.Cars;
import domain.Number;

import utils.Input;
import utils.View;
import java.util.List;

public class RacingGameController {
    private Cars createCar() {
        List<String> carNames = Input.stringInput();
        return new Cars(carNames);
    }

    private Number createCount() {
        return Input.numberInput();
    }

    public void run() {
        Cars cars = createCar();
        Number count = createCount();
        int times = count.getCount();
        while (times-- > 0) {
            cars.moveCars();
            cars.getCars().stream()
                    .forEach(Car -> View.carStatusView(Car));
            View.spacingWord();
        }
        View.resultView(cars.getWinner());
    }
}

