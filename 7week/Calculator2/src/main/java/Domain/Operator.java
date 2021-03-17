package Domain;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Stream;

public enum Operator implements  Operation{
    ADD("+") {
        @Override
        public BigDecimal calculate(ArrayDeque<Number> numbers) {
            return numbers.pollFirst().getValue().add(numbers.pollFirst().getValue());
        }
    },
    SUB("-") {
        @Override
        public BigDecimal calculate(ArrayDeque<Number> numbers) {
            return numbers.pollFirst().getValue().subtract(numbers.pollFirst().getValue());
        }
    },
    MUL("*") {
        @Override
        public BigDecimal calculate(ArrayDeque<Number> numbers) {
            return numbers.pollFirst().getValue().multiply(numbers.pollFirst().getValue());
        }
    },
    DIV("/") {
        @Override
        public BigDecimal calculate(ArrayDeque<Number> numbers) {
            return numbers.pollFirst().getValue().divide(numbers.pollFirst().getValue());
        }
    };

    private final String value;

    Operator(String operator){
        value = operator;
    }

    public static Operator find(String operatorText) {
        return Arrays.stream(values())
                .filter(operator -> operator.value.equals(operatorText))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다."));
    }
}
