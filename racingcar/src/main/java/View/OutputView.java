package View;

import racingcar.Car;
import java.util.List;

public class OutputView {
    public static final String bar = "-";

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
            System.out.print(bar);
        }
        System.out.println();
    }
}
