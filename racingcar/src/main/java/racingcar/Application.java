package racingcar;

import java.util.Scanner;

import utils.Validator;
import utils.ErrorCatcher;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] carNames;
        int cycle = 0;
        int[] nameCheck = {0, 0};
        int[] nameCheckCmp = {0, 0};

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = scanner.nextLine().split(",");
        System.out.println("시도할 회수는 몇회인가요?");
        cycle = scanner.nextInt();

        nameCheck = Validator.validateName(carNames);
        ErrorCatcher.catchNameError(nameCheck);

        if (nameCheck[0] == nameCheckCmp[0] && nameCheck[1] == nameCheckCmp[1]) {
            GameController gameController = new GameController();
            gameController.startGame(carNames, cycle);
        }
    }
}