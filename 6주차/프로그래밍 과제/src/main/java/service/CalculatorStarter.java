package service;

import view.ScannerInputView;

import java.io.IOException;

public class CalculatorStarter {

    public void start() throws IOException {
        Calculator.calculateFormula(ScannerInputView.getFormular());
    }
}
