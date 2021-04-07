package service;

import domain.Car;
import domain.Cars;
import domain.Number;

import utils.Input;
import utils.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameController {

    public Cars createCar() {
        List<String> carNames = Input.stringInput();
        return new Cars(carNames);
    }

    public Number createCount() {
        return Input.numberInput();
    }

    public void run(Cars cars, Number count) {
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

