package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operators {

    ADD("+", (num1, num2) -> num1 + num2),
    SUB("-", (num1, num2) -> num1 - num2),
    MUL("*", (num1, num2) -> num1 * num2),
    DIV("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operators(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int operate(String operator, int num1, int num2) {
        return getOperator(operator).expression.apply(num1, num2);
    }

    private static Operators getOperator(String operator) {
        return Arrays.stream(values())
                .filter(operators -> operators.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("잘못된 연산자가 입력되었습니다."));
    }

    public static int operateFormula(Number number1, Operator operator, Number number2) {
        if (operator.value.equals("/") && number2.validate()) {
            throw new IllegalArgumentException("숫자 0으로 나눌 수 없습니다.");
        }
        return operate(operator.value, number1.getValue(), number2.getValue());
    }
}
