package Service;

import Domain.Operator;
import Domain.Number;

import java.math.BigDecimal;

public class Cal {
    public BigDecimal cal(Number first, Number second, Operator operator) {

        CalOperation calOperation = new CalOperation();

        if (operator.getValue() == '+') {
            return calOperation.add(first,second);
        }
        if (operator.getValue() == '-') {
            return calOperation.sub(first,second);
        }
        if (operator.getValue() == '/') {
            return calOperation.div(first,second);
        }
        if (operator.getValue() == '*') {
            return calOperation.mul(first,second);
        }
        throw new RuntimeException("런타임 에러");
    }

}
