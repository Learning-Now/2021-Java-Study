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

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition();
            View.carStatusView(car);
        }
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
