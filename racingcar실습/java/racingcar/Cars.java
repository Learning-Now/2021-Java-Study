package racingcar;

import outpututils.OutputView;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int BOUNDARY_NUMBER = 4;
    private static List<Car> carList;
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
    }

    public static int getMax() {
        int max = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
        return max;
    }

    public static void setWinnerList(int max) {
        winner = new ArrayList<String>();
        carList.stream()
                .filter(s -> s.getPosition() == max)
                .filter(s -> winner.add(s.getName()))
                .collect(Collectors.toList());
    }

    public static ArrayList<String> getWinnerList() {
        return winner;
    }
    public static void playGames(int inputCount){
        for (int i = 0; i < inputCount; i++) {
            playGame();
            System.out.println();
        }
    }
}
