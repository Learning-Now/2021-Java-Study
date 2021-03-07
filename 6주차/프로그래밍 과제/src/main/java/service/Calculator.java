package service;

import domain.Number;
import domain.Operator;
import domain.Operators;
import view.PrinterOutputView;

public class Calculator {

    private static final int FIRST_ARGUMENT = 0;
    private static final int NEXT_ARGUMENT = 1;
    private static final int NEXT_OPERATOR = 2;
    private static int result;

    public static void calculateFormula(String[] formula) {
        result = FormulaSplitter.toInt(formula[FIRST_ARGUMENT]);
        for (int i = 1; i < formula.length; i += NEXT_OPERATOR) {
            Number calculatedResult = new Number(result);
            Operator operator = new Operator(formula[i]);
            Number nextArgument = new Number(FormulaSplitter.toInt(formula[i + NEXT_ARGUMENT]));
            result = Operators.operateFormula(calculatedResult, operator, nextArgument);
        }
        PrinterOutputView.printOutputView(result);
    }
}
