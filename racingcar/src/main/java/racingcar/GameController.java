package racingcar;

import View.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {

    public void startGame(String[] carNames, int cycle) {
        List<Car> cars = null;
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }

        OutputView.printResultTitle();

        for (int i = 0; i < cycle; i++) {
            OutputView.printResultPosition(moveCar(cars));
            System.out.println();
        }
    }

    public List<Car> moveCar(List<Car> cars) {
        for (Car car : cars) {
            car.go();
        }
        return cars;
    }
}
