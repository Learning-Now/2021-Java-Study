package utils;

import inpututils.InputView;
import outpututils.OutputView;
import racingcar.Car;
import racingcar.Cars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class GameUtils {

    public static List<Car> makeCarList(String[] splitResult) {
        return Arrays.stream(splitResult)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static void run() {

        String inputName = InputView.getCarName();
        int inputCount = InputView.getTryNumber();
        String[] splitResult = SplitString.splitString(inputName);

        Cars cars = new Cars(makeCarList(splitResult));

        for (int i = 0; i < inputCount; i++) {
            Cars.playGame();
            System.out.println();
        }

        Cars.setWinnerVector(Cars.getMax(), Cars.makeWinnerCount(Cars.getMax()));
        OutputView.printWinner(Cars.getWinnerVector(), Cars.makeWinnerCount(Cars.getMax()));

    }
}
