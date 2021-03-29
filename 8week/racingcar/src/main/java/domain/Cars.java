package domain;

import utils.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars (List<Car> cars) {
        validateCars(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCars(List<Car> cars) {
        boolean value = cars.stream()
                            .distinct()
                            .count() != cars.size();
        if (value != true) {
            throw new IllegalArgumentException("[EEROR] 이름 중복");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public void moveCars() {
        cars.stream()
                .forEachOrdered(Car::movePosition);
    }

    public int findMaxPosition() {
        int maxPostion = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
        return maxPostion;
    }

    public List<Car> getWinner() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
