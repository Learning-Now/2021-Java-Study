import view.ScannerInputView;

import java.io.InputStream;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        CalculatorApplication calculatorApplication = new CalculatorApplication(new ScannerInputView(new Scanner(System.in)));
        calculatorApplication.start();

    }
}
