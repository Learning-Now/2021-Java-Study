package racingcar;

import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private List<Car> cars;

    public void startGame(String[] carNames, int cycle) {
        cars = Arrays.asList(carNames)
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
        OutputView.printResultTitle();

        for (int i = 0; i < cycle; i++) {
            OutputView.printResultPosition(moveCar());
            System.out.println();
        }
        OutputView.printWinner(winner());
    }

    public List<Car> moveCar() {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

    public Winners winner() {
        return new Winners(cars ,cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt());
    }
}
