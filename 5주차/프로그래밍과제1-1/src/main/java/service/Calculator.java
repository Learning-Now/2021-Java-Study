package service;

import domain.Number;
import domain.Operator;
import domain.Operators;
import view.PrinterOutputView;

public class Calculator {

    private final int FIRSTARGUMENT = 0;
    private final int NEXTARGUMENT = 1;
    private final int NEXTOPERRATOR = 2;

    public void calculateFormula(String[] formula) {
        FormulaSplitter formulaSplitter = new FormulaSplitter();
        Operators operators = new Operators();

        int result = formulaSplitter.splitNumber(formula[FIRSTARGUMENT]);
        for (int i = 1; i < formula.length; i += NEXTOPERRATOR) {
            Number calculatedResult = new Number(result);
            Operator operator = new Operator(formulaSplitter.splitOperator(formula[i]));
            Number nextArgument = new Number(formulaSplitter.splitNumber(formula[i + NEXTARGUMENT]));

            result = operators.operateFormula(calculatedResult, operator, nextArgument);
        }
        PrinterOutputView.printOutputView(result);
    }
}
