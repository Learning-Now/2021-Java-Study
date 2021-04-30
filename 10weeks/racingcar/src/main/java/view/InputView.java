package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carName = scanner.nextLine().split(",");
        return (List<String>) Arrays.stream(carName);
    }

    public static int inputNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int number = scanner.nextInt();
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자를 입력하셨습니다.\n");
        }
    }
}