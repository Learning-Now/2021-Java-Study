package utils;

import inpututils.InputView;
import outpututils.OutputView;
import racingcar.Car;

import java.util.Vector;

public class GameUtils {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    private static InputView inputView = new InputView();
    private static SplitString splitString = new SplitString();
    private static GameUtils gameUtils = new GameUtils();
    private static OutputView outputView = new OutputView();

    private static Car[] carList;
    private static Vector<String> winner;

    public static boolean move(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public static void makeCarList(String[] splitResult) {
        carList = new Car[splitResult.length];
        for (int i = 0; i < splitResult.length; i++) {
            carList[i] = new Car(splitResult[i]);
        }
    }

    public static void playGame(Car[] carList) {
        for (int j = 0; j < carList.length; j++) {
            Boolean isMove = gameUtils.move(RandomUtils.nextInt(START_NUMBER, END_NUMBER));
            outputView.printCarName(carList[j].getName());

            if (isMove) {
                carList[j].plusPosition();
            }
            for (int k = 0; k < carList[j].getPosition(); k++) {
                outputView.printMove();
            }
            System.out.println();
        }
    }

    public static int getMax(Car[] carList) {
        int max = carList[0].getPosition();
        for (int i = 1; i < carList.length; i++) {
            if (max < carList[i].getPosition()) {
                max = carList[i].getPosition();
            }
        }
        return max;
    }

    public static int makeWinnerCount(int max, Car[] carList) {
        int count = 0;
        for (int i = 0; i < carList.length; i++) {
            if (max == carList[i].getPosition()) {
                count++;
            }
        }
        return count;
    }

    public static void setWinnerVector(int max, Car[] carList, int count) {
        winner = new Vector<String>(count);
        for (int i = 0; i < carList.length; i++) {
            if (max == carList[i].getPosition()) {
                winner.add(carList[i].getName());
            }
        }
    }

    public static Vector<String> getWinnerVector() {
        return winner;
    }

    public static void run() {

        String inputName = inputView.getCarName();
        int inputCount = inputView.getTryNumber();
        String[] splitResult = splitString.splitString(inputName);

        makeCarList(splitResult);

        for (int i = 0; i < inputCount; i++) {
            playGame(carList);
            System.out.println();
        }

        setWinnerVector(getMax(carList), carList, makeWinnerCount(getMax(carList), carList));
        outputView.printWinner(getWinnerVector(), makeWinnerCount(getMax(carList), carList));

    }
}
