package service;

import domain.Car;
import domain.Cars;
import domain.GameCounter;
import domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

import static view.InputView.inputCarNames;
import static view.InputView.inputGameCount;
import static view.OutputView.printGamePreview;
import static view.OutputView.printGameResult;
import static view.OutputView.nextLine;

public class Game {
    private static final int FINAL_ROUND = 0;

    public void play() {
        Cars cars = new Cars(makeCars(inputCarNames()));
        GameCounter gameCounter = inputGameCount();
        printGamePreview();
        while (gameCounter.nextRound() > FINAL_ROUND) {
            cars.moveCars();
            cars.printCars();
            nextLine();
        }
        Winners winners = cars.findWinner();
        printGameResult(winners);
    }

    private List<Car> makeCars(final List<String> carList) {
        return carList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
