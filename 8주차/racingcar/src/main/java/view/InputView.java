package view;

import domain.GameCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final String DELIMITER = ",";

    private InputView() {

    }

    public static GameCounter inputGameCount() {
        OutputView.printGameCounterInput();
        try {
            String inputNumber = BUFFERED_READER.readLine();
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
        OutputView.printCarInput();
        try {
            String input = BUFFERED_READER.readLine();
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
