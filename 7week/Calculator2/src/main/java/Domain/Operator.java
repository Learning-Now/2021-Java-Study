package Domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

public enum Operator {
    ADD("+") {
        @Override
        public BigDecimal calculate(Number firstValue, Number secondValue) {
            return firstValue.getValue().add(secondValue.getValue());
        }
    },
    SUB("-") {
        @Override
        public BigDecimal calculate(Number firstValue, Number secondValue) {
            return firstValue.getValue().subtract(secondValue.getValue());
        }
    },
    MUL("*") {
        @Override
        public BigDecimal calculate(Number firstValue, Number secondValue) {
            return firstValue.getValue().multiply(secondValue.getValue());
        }
    },
    DIV("/") {
        @Override
        public BigDecimal calculate(Number firstValue, Number secondValue) {
            return firstValue.getValue().divide(secondValue.getValue());
        }
    };

    private final String value;

    Operator(String operator){
        value = operator;
    }

    public static Operator from(String operatorText) {
        return Arrays.stream(values())
                .filter(operator -> operator.value.equals(operatorText))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다."));
    }
    public abstract BigDecimal calculate(Number firstValue, Number secondValue);
}
