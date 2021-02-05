package service;

import domain.Number;
import domain.Operator;
import domain.Operators;
import view.PrinterOutputView;

public class Calculator {

    ExceptionCatcher exceptionCatcher = new ExceptionCatcher();
    Operators operators = new Operators();

    public void calculateFormula(String[] formula) {

        Number result = new Number(exceptionCatcher.catchWrongNumber(formula[0]));
        for (int i = 1; i < formula.length; i += 2) {
            Operator operator = new Operator(exceptionCatcher.catchWrongString(formula[i]));
            Number number = new Number(exceptionCatcher.catchWrongNumber(formula[i + 1]));

            int tmp = operators.operateFormula(result, operator, number);
            result.setValue(tmp);
        }

        new PrinterOutputView(result.getValue());
    }
}
