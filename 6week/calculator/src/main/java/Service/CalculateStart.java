package Service;

import Domain.Operator;
import Domain.Number;
import Domain.Operators;

import java.math.BigDecimal;

public class CalculateStart {
    public static final int FIRSTNUM = 0;
    public static final int OPERATOR = 1;
    public static final int SECONDNUM = 2;
    public void stringCalculateStart(String[] str) {
        try {
            Number first = new Number(new BigDecimal(str[FIRSTNUM]));
            if (str.length % 2 == 0) {
                throw new IllegalArgumentException("잘못된 입력 입니다.");
            }
            for (int i = 0; i < str.length - 2; i += 2) {
                Number second = new Number(new BigDecimal(str[i+SECONDNUM]));
                Operator operator = new Operator(str[i + OPERATOR].charAt(0));
                first.value = Operators.calculateOperation(operator,first,second);
            }
            View.resultView(first.value);
        } catch (RuntimeException e) {
            throw new RuntimeException("잘못된 연산 입니다.");
        }
    }
}
