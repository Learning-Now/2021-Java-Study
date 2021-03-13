package service;

import domain.Number;
import domain.Operator;
import view.PrinterOutputView;

public class Calculator {

    private static final int FIRST_INDEX = 0;
    private static final int INDEX_INTERVAL_ONE = 1;
    private static final int INDEX_INTERVAL_TWO = 2;

    private Calculator() {
    }

    public static void start(String[] formula) {
        Number resultNumber = new Number(formula[FIRST_INDEX]);
        for (int i = 1; i < formula.length; i += INDEX_INTERVAL_TWO) {
            Number calculatedResult = resultNumber;
            Operator operator = Operator.find(formula[i]);
            Number nextArgument = new Number(formula[i + INDEX_INTERVAL_ONE]);
            String stringResult = Integer.toString(operator.calculate(calculatedResult.getValue(), nextArgument.getValue()));
            resultNumber = new Number(stringResult);
        }
        PrinterOutputView.printOutputView(resultNumber);
    }
}
