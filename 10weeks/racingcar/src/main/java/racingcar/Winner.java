package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinnersName() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}