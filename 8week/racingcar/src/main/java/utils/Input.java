package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {

    private Input() {};

    public static String[] stringInput() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String buffer = bf.readLine();
            if (buffer.contains(" ")){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            return buffer.split(",");
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static int intInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            int count = scanner.nextInt();
            return count;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}
