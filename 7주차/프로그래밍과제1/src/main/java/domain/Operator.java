package domain;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public String calculate(Number firstValue, Number secondValue) {
            return Integer.toString(firstValue.getValue() + secondValue.getValue());
        }
    },
    MINUS("-") {
        @Override
        public String calculate(Number firstValue, Number secondValue) {
            return Integer.toString(firstValue.getValue() - secondValue.getValue());
        }
    },
    MULTIPLY("*") {
        @Override
        public String calculate(Number firstValue, Number secondValue) {
            return Integer.toString(firstValue.getValue() * secondValue.getValue());
        }
    },
    DIVIDE("/") {
        @Override
        public String calculate(Number firstValue, Number secondValue) {
            int WRONG_ARGUMENT = 0;
            if (secondValue.getValue() == WRONG_ARGUMENT) {
                throw new IllegalArgumentException("숫자 0으로 나눌 수 없습니다.");
            }
            return Integer.toString(firstValue.getValue() / secondValue.getValue());
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator find(String operatorText) {
        return Arrays.stream(values())
                .filter(operator -> operator.operator.equals(operatorText))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다."));
    }

    public abstract String calculate(Number firstValue, Number secondValue);
}
