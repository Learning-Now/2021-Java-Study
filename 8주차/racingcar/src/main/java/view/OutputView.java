package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private OutputView() {

    }

    private static void printCarName(final String carName) {
        System.out.print(carName + " : ");
    }

    private static void printCarPosition(final int carPosition) {
        IntStream.range(0, carPosition)
                .mapToObj(s -> "-")
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printGameStatus(final String carName, final int carPosition) {
        printCarName(carName);
        printCarPosition(carPosition);
    }

    public static void printGameResult(final List<Car> winners) {
        System.out.print("최종 우승자: ");
        String winner = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winner);
    }
}
