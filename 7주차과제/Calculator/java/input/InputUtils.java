package input;

import java.util.Scanner;

public class InputUtils{
    private static final Scanner SCANNER = new Scanner(System.in);
    // 문자열 입력 받기
    public String getNextLine() {
        return SCANNER.nextLine();
    }
}
