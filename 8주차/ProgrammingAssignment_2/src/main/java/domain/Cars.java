package domain;

import java.util.List;
import java.util.stream.Collectors;

import static view.OutputView.*;

public class Cars {
    private final List<Car> cars;
    private int maxPosition;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        cars.forEach(Car::go);
    }

    public void printCars() {
        cars.forEach(car ->
                printGameStatus(car.getName(), car.getPosition()));
    }

    public Cars findWinner() {
        maxPosition = cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
        return new Cars(cars
                .stream()
                .filter(car -> isMaxPosition(car.getPosition()))
                .collect(Collectors.toList()));
    }

    private boolean isMaxPosition(final int position) {
        return position == maxPosition;
    }
}
