package utils;

import domain.Car;
import domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameStatusView {
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String POSITION_VIEW = "-";

    private RacingGameStatusView() {};

    public static void distanceView(int position) {
        while (position-- > 0){
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

    public static void carStatusView(Cars cars) {
        cars.getCars()
                .stream()
                .forEach(car -> {
                        RacingGameStatusView.carNameView(car.getName());
                        RacingGameStatusView.distanceView(car.getPosition());
                });
    }

    public static void spacingWord() {
        System.out.println();
    }
}
