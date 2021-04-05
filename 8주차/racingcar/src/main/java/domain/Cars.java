package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static view.OutputView.printGameStatus;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validate(List<Car> cars) {
        boolean checkName = cars.stream()
                .map(Car::getName)
                .distinct()
                .count() != cars.size();
        if (checkName) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름입니다.");
        }
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> Engine.isPower())
                .forEach(Car::go);
    }

    public void printCars() {
        cars.forEach(car ->
                printGameStatus(car.getName(), car.getPosition()));
    }

    public Winners findWinner() {
        return new Winners(cars.stream()
                .filter(car -> isMaxPosition(car.getPosition()))
                .map(Winner::new)
                .collect(Collectors.toList()));
    }

    private boolean isMaxPosition(final int position) {
        return cars
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt() == position;
    }
}
