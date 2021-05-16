package racingcar;

import view.InputView;
import utils.Validator;
import utils.ErrorCatcher;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] carNames = inputView.inputCarNames();
        int cycle = inputView.inputCycle();
        int nameLongCheck = Validator.isGoodLength(carNames);
        boolean nameOnlyCheck = !Validator.isNameOnly(carNames);

        if (checkError(nameLongCheck, nameOnlyCheck)) {
            run(carNames, cycle);
        }
    }

    public static boolean checkError(int nameLongCheck, boolean nameOnlyCheck) {
        ErrorCatcher.catchNameError(nameLongCheck, nameOnlyCheck);

        if (nameLongCheck == 0 && nameOnlyCheck == true) {
            return true;
        }

        return false;
    }

    public static void run(String[] carNames, int cycle) {
        GameController gameController = new GameController();
        gameController.startGame(carNames, cycle);
    }
}
