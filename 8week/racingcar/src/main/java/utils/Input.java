package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {

    private Input() {};

    public static String[] stringInput() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String buffer = bf.readLine();
            return buffer.split(",");
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

    public static int intInput() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            Scanner scanner = new Scanner(System.in);
            int count = scanner.nextInt();
            return count;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }

}
