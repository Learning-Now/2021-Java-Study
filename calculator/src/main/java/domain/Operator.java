package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    private static final Map<String, Operator> OPERATORS = new HashMap<>();

    static {
        for (Operator value : values()) {
            OPERATORS.put(value.operator, value);
        }
    }

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator from(String operatorText) {
        Operator operator = OPERATORS.getOrDefault(operatorText, null);
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException("잘못된 연산자 입니다.");
        }
        return operator;
    }

    public abstract int calculate(int firstValue, int secondValue);
}
