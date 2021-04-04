package view;

import domain.GameCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private InputView() {

    }

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String DELIMITER = ",";

    public static GameCounter inputGameCount() {
        System.out.println("시도할 횟수는 몇회인가요? ");
        try {
            String inputNumber = bufferedReader.readLine();
            validateGameCount(inputNumber);
            return new GameCounter(inputNumber);
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    private static void validateGameCount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String input = bufferedReader.readLine();
            validateCarNames(input);
            return Arrays.asList(input.split(DELIMITER));
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    private static void validateCarNames(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름을 입력해 주세요.");
        }
    }
}
