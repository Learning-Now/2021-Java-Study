package service;

import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    private int maxPosition;

    public void play() {
        final List<Car> cars = splitCars(InputView.inputCarNames());
        final int gameCount = InputView.inputGameCount();
        run(cars, gameCount);
        final List<Car> winner = findWinner(cars);
        OutputView.printGameResult(winner);
    }

    private List<Car> splitCars(final String[] carList) {
        return IntStream.range(0, carList.length)
                .mapToObj(index -> new Car(carList[index]))
                .collect(Collectors.toList());
    }

    private void run(final List<Car> cars, final int gameCount) {
        for (int index = 0; index < gameCount; index++) {
            cars.stream()
                    .map(car -> {
                        car.go();
                        OutputView.printGameStatus(car);
                        return car;
                    })
                    .forEachOrdered(car -> System.out.print(""));
            System.out.println();
        }
    }

    private List<Car> findWinner(final List<Car> cars) {
        maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
        return cars.stream()
                .filter(car -> isMaxPosition(car.getPosition()))
                .collect(Collectors.toList());
    }

    private boolean isMaxPosition(final int position) {
        return position == maxPosition;
    }
}
