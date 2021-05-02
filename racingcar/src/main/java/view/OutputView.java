package view;

import racingcar.Car;

import java.util.List;

import racingcar.Winners;

public class OutputView {
    public static final String PROGRESS = "-";
    public static int maxReach;

    private OutputView() {

    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public static void printResultPosition(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
    }

    public static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(PROGRESS);
        }
        System.out.println();

        if (maxReach < car.getPosition()) {
            maxReach = car.getPosition();
        }
    }

    public static void printWinner(Winners winners) {
        System.out.println("최종 우승자");
        System.out.print(winners.getWinnersName());
    }
}