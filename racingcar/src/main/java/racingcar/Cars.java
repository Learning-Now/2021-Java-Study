package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> run() {
        for (Car car: cars) {
            car.move();
        }
        return cars;
    }

    public Winner findWinner() {
        return new Winner(cars ,cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt());
    }
}
