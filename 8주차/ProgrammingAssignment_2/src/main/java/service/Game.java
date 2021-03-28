package service;

import domain.Car;
import domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static view.InputView.*;
import static view.OutputView.*;

public class Game {
    public void play() {
        final Cars cars = new Cars(splitCars(inputCarNames()));
        final int gameCount = inputGameCount();
        run(cars, gameCount);
        final Cars winners = cars.findWinner();
        printGameResult(winners.getCars());
    }

    private List<Car> splitCars(final String[] carList) {
        return Arrays.stream(carList)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void run(final Cars cars, final int gameCount) {
        System.out.println("\n실행결과");
        for (int index = 0; index < gameCount; index++) {
            cars.moveCars();
            cars.printCars();
            System.out.println();
        }
    }
}
