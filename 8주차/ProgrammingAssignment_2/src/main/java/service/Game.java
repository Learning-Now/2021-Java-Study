package service;

import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
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
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
