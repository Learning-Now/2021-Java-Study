package service;

import view.ScannerInputView;

import java.io.IOException;

public class CalculatorStarter {

    public void start() throws IOException {
        ScannerInputView scannerInputView = new ScannerInputView();
        Calculator calculator = new Calculator();
        calculator.calculateFormula(scannerInputView.getFormular());
    }
}
