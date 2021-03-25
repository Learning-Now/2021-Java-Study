package utils;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Sort {
    private Sort() {};

    public static List<Car> sortList(List<Car> cars) {
        List<Car> sortedCars = cars.stream()
                .sorted((a, b) -> b.getPosition() - a.getPosition())
                .collect(Collectors.toList());
        return sortedCars;
    }
}
