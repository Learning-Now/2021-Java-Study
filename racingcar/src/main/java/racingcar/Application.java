package racingcar;

import view.InputView;
import utils.Validator;
import utils.ErrorCatcher;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames;
        int cycle = 0;
        int[] nameCheck = {0, 0};

        carNames = inputView.inputCarNames();
        cycle = inputView.inputCycle();

        nameCheck = Validator.validateName(carNames);
        ErrorCatcher.catchNameError(nameCheck);

        if (nameCheck[0] == 0 && nameCheck[1] == 0) {
            GameController gameController = new GameController();
            gameController.startGame(carNames, cycle);
        }
    }
}