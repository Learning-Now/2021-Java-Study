package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars (List<String> carNames) {
        validateCars(carNames);
        this.cars = carNames.stream()
                .map(carName->new Car(carName))
                .collect(Collectors.toList());
    }

    private void validateCars(List<String> carNames) {
        Boolean value = (int) carNames.stream()
                .distinct()
                .count() != carNames.size();
        if (value) {
            throw new IllegalArgumentException("[ERROR] 이름 중복");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public void moveCars() {
        cars.stream()
                .forEach(Car::movePosition);
    }

    public int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }

    public List<Car> getWinner() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
