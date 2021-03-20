package util;

import domain.Operand;
import domain.Operator;
import input.InputView;

import java.io.IOException;

public class Calculator {
    private static double result = 0;

    private Calculator() {
    }

    public static void run() throws IOException {
        InputView inputView = new InputView();
        String[] formula = inputView.inputFormula();
        for(int operatorPosition = 1; operatorPosition < formula.length; operatorPosition += 2) {
            Operand firstOperand = new Operand(formula[operatorPosition - 1]);
            Operator operator = new Operator(formula[operatorPosition]);
            Operand secondOperand = new Operand(formula[operatorPosition + 1]);

            result = OperationType.calculate(operator.getOperator(),firstOperand.getOperand(),secondOperand.getOperand());
            formula[operatorPosition + 1] = Double.toString(result);
        }
        System.out.println("계산 값 : " + (int)result);
    }
}
