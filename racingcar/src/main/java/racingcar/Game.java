package racingcar;

import view.InputView;
import view.ResultView;

public class Game {

    public void start() {
        Cars cars = new Cars(InputView.inputCarName());
        int gameNumber = InputView.inputNumber();

        ResultView.printResultTitle();

        for (int i = 0; i < gameNumber; i++) {
            ResultView.printResultPosition(cars.run());
            System.out.println();
        }

        ResultView.printWinners(cars.findWinner());
    }
}
