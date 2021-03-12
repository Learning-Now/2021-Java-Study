package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderInputView {

    private BufferedReaderInputView() {
    }

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String[] input() {
        try {
            String[] formulaArgument = bufferedReader.readLine().split(" ");
            return formulaArgument;
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
