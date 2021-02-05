package domain;

import domain.Number;
import domain.Operator;

public class Operators {

    private int resultNum;

    public int operateFormula(Number number1, Operator operator, Number number2) {
        if (operator.getValue().equals("+")) {
            resultNum = addNumber(number1, number2);
        } else if (operator.getValue().equals("-")) {
            resultNum = subNumber(number1, number2);
        } else if (operator.getValue().equals("*")) {
            resultNum = multiNumber(number1, number2);
        } else if (operator.getValue().equals("/")) {
            resultNum = divNumber(number1, number2);
        }
        return resultNum;
    }

    private int addNumber(Number num1, Number num2) {
        return num1.getValue() + num2.getValue();
    }

    private int subNumber(Number num1, Number num2) {
        return num1.getValue() - num2.getValue();
    }

    private int multiNumber(Number num1, Number num2) {
        return num1.getValue() * num2.getValue();
    }

    private int divNumber(Number num1, Number num2) {
        if (num2.getValue() == 0) {
            throw new IllegalArgumentException("숫자 0으로 나눌 수 없습니다.");
        }
        return num1.getValue() / num2.getValue();
    }
}
