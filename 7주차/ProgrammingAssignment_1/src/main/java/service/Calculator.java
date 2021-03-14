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
        for (int index = 1; index < formula.length; index += INDEX_INTERVAL_TWO) {
            Number calculatedResult = resultNumber;
            Number nextArgument = new Number(formula[index + INDEX_INTERVAL_ONE]);
            String stringResult = Operator.find(formula[index])
                    .calculate(calculatedResult, nextArgument);
            resultNumber = new Number(stringResult);
        }
        PrinterOutputView.printOutputView(resultNumber);
    }
}
