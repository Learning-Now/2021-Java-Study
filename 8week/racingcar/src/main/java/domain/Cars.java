package domain;

import utils.View;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars (List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        cars.stream()
                .peek(Car::movePosition)
                .forEachOrdered(car-> View.carStatusView(car));
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
