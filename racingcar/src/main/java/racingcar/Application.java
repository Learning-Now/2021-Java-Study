package racingcar;

import java.util.Scanner;
import utils.Validator;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        String carName;
        int cycle;
        int[] nameCheck = {0, 0};
        int[] nameCheckCmp = {0, 0};

        carName = scanner.next();
        cycle = scanner.nextInt();
        String[] carNames = carName.split(",");

        nameCheck = Validator.validateName(carNames);

        if (nameCheck.equals(nameCheckCmp)) {
            GameController gameController = new GameController();
            gameController.startGame();
        }

    }
}