package view;

import racingcar.Car;
import racingcar.Winner;

import java.util.List;

public class ResultView {
    public static final String POSITION = "-";

    private ResultView() { }

    public static void printResultTitle(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResultPosition(List<Car> cars){
        for(Car car : cars) {
            printCarPosition(car);
        }
    }

    public static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION);
        }
        System.out.println();
    }

    public static void printWinners(Winner winner) {
        System.out.println("최종 우승자: "  + winner.getWinnersName());
    }
}