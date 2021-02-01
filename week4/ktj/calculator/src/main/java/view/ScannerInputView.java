package view;

import java.util.Scanner;

public class ScannerInputView implements InputView {

    private final Scanner scanner;

    public ScannerInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextValue() {
        return scanner.nextLine();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }
}
