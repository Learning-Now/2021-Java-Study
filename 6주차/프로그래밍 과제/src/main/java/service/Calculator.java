package service;

import domain.Number;
import domain.Operator;
import domain.Operators;
import view.PrinterOutputView;

public class Calculator {

    private final int FIRST_ARGUMENT = 0;
    private final int NEXT_ARGUMENT = 1;
    private final int NEXT_OPERRATOR = 2;
    private int result;

    public void calculateFormula(String[] formula) {
        FormulaSplitter formulaSplitter = new FormulaSplitter();

        result = formulaSplitter.toInt(formula[FIRST_ARGUMENT]);
        for (int i = 1; i < formula.length; i += NEXT_OPERRATOR) {
            Number calculatedResult = new Number(result);
            Operator operator = new Operator(formula[i]);
            Number nextArgument = new Number(formulaSplitter.toInt(formula[i + NEXT_ARGUMENT]));
            result = Operators.operateFormula(calculatedResult, operator, nextArgument);
        }
        PrinterOutputView.printOutputView(result);
    }
}
