package utils;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class View {

    private View() {};

    public static void distanceView(final int positon) {
        for (int count = 0; count < positon; count ++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void carNameView(final String name){
        System.out.print(name + " : ");
    }

    public static void resultView(final List<Car> cars){
        System.out.print("최종 우승자 : ");
        String winner = cars.stream()
                            .map(Car::getName)
                            .collect(Collectors.joining(", "));
        System.out.println(winner);
    }

    public static void carStatusView(Car car) {
        View.carNameView(car.getName());
        View.distanceView(car.getPosition());
    }

    public static void spacingWord() {
        System.out.println();
    }
}
