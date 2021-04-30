package service;

import domain.Cars;
import domain.GameCounter;
import domain.Winners;
import view.OutputView;

import static view.InputView.inputCarNames;
import static view.InputView.inputGameCount;

public class Game {
    private static final int FINAL_ROUND = 0;

    public void play() {
        Cars cars = new Cars(inputCarNames());
        GameCounter gameCounter = inputGameCount();
        OutputView.printGamePreview();
        while (gameCounter.nextRound() > FINAL_ROUND) {
            cars.moveCars();
            cars.printCars();
            OutputView.nextLine();
        }
        Winners winners = cars.findWinner();
        OutputView.printGameResult(winners);
    }
}
