package view;

import domain.Winners;

import java.util.stream.IntStream;

public class OutputView {
    private static final String POSITION_DISPLAY = "-";

    private OutputView() {

    }

    private static void printCarName(final String carName) {
        System.out.print(carName + " : ");
    }

    private static void printCarPosition(final int carPosition) {
        IntStream.range(0, carPosition)
                .mapToObj(s -> POSITION_DISPLAY)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printGameStatus(final String carName, final int carPosition) {
        printCarName(carName);
        printCarPosition(carPosition);
    }

    public static void printGameResult(final Winners winners) {
        System.out.print("최종 우승자: ");
        System.out.println(winners.winnersToString());
    }

    public static void printGamePreview() {
        System.out.println("\n실행결과");
    }

    public static void nextLine() {
        System.out.println();
    }
}
