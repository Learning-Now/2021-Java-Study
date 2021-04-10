package racingcar;

import outpututils.OutputView;
import utils.GameUtils;
import utils.RandomUtils;

import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

public class Cars {
    private static List<Car> carList;

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    private static final int BOUNDARY_NUMBER = 4;

    private static ArrayList<String> winner;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static boolean isMove(int randomNumber) {
        if (randomNumber >= BOUNDARY_NUMBER) {
            return true;
        }
        return false;
    }

    public static void playGame() {
        for (int j = 0; j < carList.size(); j++) {

            OutputView.printCarName(carList.get(j).getName());

            if (isMove(RandomUtils.nextInt(START_NUMBER, END_NUMBER))) {
                carList.get(j).plusPosition();
            }
            for (int k = 0; k < carList.get(j).getPosition(); k++) {
                OutputView.printMove();
            }
            System.out.println();
        }
/*
        carList.stream()
                .map(Car::getName)
                .forEach(car -> OutputView.printCarName(car));
        for (int i = 0; i < carList.size(); i++) {
            IntStream.range(0, carList.get(i).getPosition())
                    .forEach(OutputView.printMove();
        }
*/
    }

    public static int getMax() {
        int max = carList.get(0).getPosition();
        for (int i = 1; i < carList.size(); i++) {
            if (max < carList.get(i).getPosition()) {
                max = carList.get(i).getPosition();
            }
        }
        return max;
    }
    public static int makeWinnerCount(int max) {
        int count = 0;
        for (int i = 0; i < carList.size(); i++) {
            if (max == carList.get(i).getPosition()) {
                count++;
            }
        }
        return count;
    }
    public static void setWinnerList(int max, int count) {
        winner = new ArrayList<String>(count);
        for (int i = 0; i < carList.size(); i++) {
            if (max == carList.get(i).getPosition()) {
                winner.add(carList.get(i).getName());
            }
        }
    }
    public static ArrayList<String> getWinnerList() {
        return winner;
    }







}
