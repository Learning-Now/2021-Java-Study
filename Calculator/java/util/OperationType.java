package util;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperationType {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if(b == 0) throw new IllegalArgumentException("정수를 0으로 나눌 수 없습니다.");
        return a / b;
    });

    private String operator;
    private BiFunction<Double, Double, Double> biFunction;

    OperationType(String operator, BiFunction<Double, Double, Double> biFunction){
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static Double calculate(String operator, Double firstOperand, Double secondOperand){
        return getOperate(operator)
                .biFunction
                .apply(firstOperand, secondOperand);
    }

    private static OperationType getOperate(String operator) {
        OperationType operationType = Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
        return operationType;
    }
}
