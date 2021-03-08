package domain;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int firstValue, int secondValue) {
            return firstValue + secondValue;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int firstValue, int secondValue) {
            return firstValue - secondValue;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int firstValue, int secondValue) {
            return firstValue * secondValue;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int firstValue, int secondValue) {
            return firstValue / secondValue;
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator from(String operatorText) {
        return Arrays.stream(values())
                .filter(operator -> operator.operator.equals(operatorText))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 입니다."));
    }

    public abstract int calculate(int firstValue, int secondValue);
}
