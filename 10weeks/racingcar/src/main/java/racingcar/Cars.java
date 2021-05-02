
package racingcar;

import java.util.Comparator;
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
        int maxPosition = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow()
                .getPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return new Winner(winners);
    }
}