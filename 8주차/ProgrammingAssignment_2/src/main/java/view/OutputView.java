package view;

import domain.Car;
import domain.Cars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private OutputView() {

    }

    private static void printCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private static void printCarPosition(Car car) {
        IntStream.range(0, car.getPosition())
                .mapToObj(s -> "-")
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printGameStatus(Car car) {
        printCarName(car);
        printCarPosition(car);
    }

    public static void printGameResult(Cars winners) {
        System.out.print("최종 우승자: ");
        String winner = winners.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winner);
    }
}
