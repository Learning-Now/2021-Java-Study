package view;

import domain.Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private InputView() {

    }

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static int inputGameCount() {
        System.out.println("시도할 횟수는 몇회인가요? ");
        try {
            Number carNumber = new Number(bufferedReader.readLine());
            return carNumber.getValue();
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력이다.");
        }
    }

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String[] cars = bufferedReader.readLine().split(",");
            return cars;
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력이다.");
        }
    }
}
