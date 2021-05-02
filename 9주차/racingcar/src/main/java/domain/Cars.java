package domain;

import java.util.List;
import java.util.stream.Collectors;

import static view.OutputView.printGameStatus;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        validate(cars);
        this.cars = cars
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> cars) {
        boolean checkName = cars.stream()
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
        Car maxPositionCar = findMaxPositionCar();
        return new Winners(cars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(Winner::new)
                .collect(Collectors.toList()));
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력된 차량이 없습니다."));
    }
}
