package util;

import domain.Operand;
import domain.Operator;
import input.InputView;

import java.io.IOException;

public class Calculator {
    private static double result = 0;

    public void run() throws IOException {
        InputView inputView = new InputView();
        String[] str = inputView.inputExpr();
        for(int op = 1; op < str.length; op += 2) {
            Operand firstOperand = new Operand(str[op - 1]);
            Operator operator = new Operator(str[op]);
            Operand secondOperand = new Operand(str[op + 1]);
            formula(firstOperand.getOperand(), operator, secondOperand.getOperand());
            str[op + 1] = Double.toString(result);
        }
        System.out.println("계산 값 : " + (int)result);
    }

    private double formula(double firstValue, Operator operator, double secondValue){
        if(operator.getOperator().equals("+")){
            result = add(firstValue,secondValue);
        }
        if(operator.getOperator().equals("-")){
            result = sub(firstValue,secondValue);
        }
        if(operator.getOperator().equals("*")){
            result = mul(firstValue,secondValue);
        }
        if(operator.getOperator().equals("/")){
            result = div(firstValue,secondValue);
        }
        return result;
    }

    private double add(double firstValue, double secondValue){

        return firstValue + secondValue;
    }

    private double sub(double firstValue, double secondValue){

        return firstValue - secondValue;
    }

    private double mul(double firstValue, double secondValue){

        return firstValue * secondValue;
    }

    private double div(double firstValue, double secondValue){

        return firstValue / secondValue;
    }
}
