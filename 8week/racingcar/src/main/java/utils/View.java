package utils;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class View {
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String POSITION_VIEW = "-";

    private View() {};

    public static void distanceView(final int position) {
        for (int count = 0; count < position; count ++) {
            System.out.print(POSITION_VIEW);
        }
        System.out.println();
    }

    public static void carNameView(final String name){
        System.out.print(name + COLON);
    }

    public static void resultView(final List<Car> cars){
        System.out.print(FINAL_WINNER);
        String winner = cars.stream()
                            .map(Car::getName)
                            .collect(Collectors.joining(COMMA));
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
