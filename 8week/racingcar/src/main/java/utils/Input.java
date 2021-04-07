package utils;

import domain.Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static final String SPLIT_RULE = ",";
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    private Input() {};

    public static String[] stringInput() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String buffer = BUFFERED_READER.readLine();
            return buffer.split(SPLIT_RULE);
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public static Number numberInput() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String buffer = BUFFERED_READER.readLine();
            Number number = new Number(buffer);
            return number;
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

}
