package service;

import domain.Car;
import domain.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static view.InputView.*;
import static view.OutputView.*;

public class Game {
    private int maxPosition;

    public void play() {
        final Cars cars = new Cars(splitCars(inputCarNames()));
        final int gameCount = inputGameCount();
        run(cars, gameCount);
        final Cars winner = findWinner(cars);
        printGameResult(winner.getCars());
    }

    private List<Car> splitCars(final String[] carList) {
        return Arrays.stream(carList)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void run(final Cars cars, final int gameCount) {
        for (int index = 0; index < gameCount; index++) {
            cars.getCars().forEach(Car::go);
            cars.getCars().forEach(
                    car -> printGameStatus(car.getName(), car.getPosition()));
            System.out.println();
        }
    }

    private Cars findWinner(final Cars cars) {
        maxPosition = cars.getCars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
        return new Cars(cars.getCars()
                .stream()
                .filter(car -> isMaxPosition(car.getPosition()))
                .collect(Collectors.toList()));
    }

    private boolean isMaxPosition(final int position) {
        return position == maxPosition;
    }
}
