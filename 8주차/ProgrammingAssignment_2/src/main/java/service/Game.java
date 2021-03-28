package service;

import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int maxPosition;

    public void play() {
        final Cars cars = new Cars(splitCars(InputView.inputCarNames()));
        final int gameCount = InputView.inputGameCount();
        run(cars, gameCount);
        final Cars winner = findWinner(cars);
        OutputView.printGameResult(winner);
    }

    private List<Car> splitCars(final String[] carList) {
        return Arrays.stream(carList)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void run(final Cars cars, final int gameCount) {
        for (int index = 0; index < gameCount; index++) {
            cars.getCars().forEach(Car::go);
            cars.getCars().forEach(OutputView::printGameStatus);
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
