package inpututils;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public String getCarName() {
        System.out.print("경주 할 자동차 이름 : ");
        return SCANNER.nextLine();
    }

    public int getTryNumber() {
        System.out.print("시도할 횟수 : ");
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }
}
