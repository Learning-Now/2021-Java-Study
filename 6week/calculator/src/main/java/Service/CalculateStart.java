package Service;

import Domain.Operator;
import Domain.Number;
import Domain.Operators;

import java.math.BigDecimal;

public class CalculateStart {
    public static final int FIRST_NUM = 0;
    public static final int OPERATOR = 1;
    public static final int SECOND_NUM = 2;
    public void stringCalculateStart(String[] str) {
        try {
            Number first = new Number(new BigDecimal(str[FIRST_NUM]));
            for (int i = 0; i < str.length - 2; i += 2) {
                Number second = new Number(new BigDecimal(str[i+SECOND_NUM]));
                Operator operator = new Operator(str[i + OPERATOR].charAt(0));
                first = new Number(Operators.calculateOperation(operator, first, second));
            }
            View.resultView(first.getValue());
        } catch (RuntimeException e) {
            throw new RuntimeException("잘못된 연산 입니다.");
        }
    }
}
