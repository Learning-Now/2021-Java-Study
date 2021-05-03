package domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Cars {
    private final List<Car> cars;
    private static final int START_NUMBER = 0;
    private static final int FINISH_NUMBER = 10;

    public Cars (List<String> carNames) {
        validateCars(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
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
                .forEach(Car-> Car.movePosition(RandomUtils.randomIntGenerator(START_NUMBER, FINISH_NUMBER)));
    }

    private Car findMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 차량 리스트가 비었습니다."));
    }

    public List<Car> getWinner() {
        return cars.stream()
                .filter(car -> car.isSamePosition(findMaxPosition()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
