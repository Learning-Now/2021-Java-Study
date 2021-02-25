package Domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.BiFunction;

import static java.math.BigDecimal.ZERO;

public enum Operators {
    ADD('+', (num1, num2) -> num1.add(num2)),
    SUB('-', (num1, num2) -> num1.subtract(num2)),
    MUL('*', (num1, num2) -> num1.multiply(num2)),
    DIV('/', (num1, num2) -> num1.divide(num2));

    private final char operator;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> biFunction;

    Operators(char operator, BiFunction<BigDecimal, BigDecimal, BigDecimal> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static BigDecimal operate(char operator, BigDecimal num1, BigDecimal num2) {
        return getResult(operator).biFunction.apply(num1, num2);
    }

    public static Operators getResult(char operator) {
        return Arrays.stream(values())
                .filter(operators -> operators.operator == operator)
                .findFirst().orElseThrow(()-> new IllegalArgumentException("잘못된 연산자가 입력되었습니다."));
    }

    public static BigDecimal calculateOperation(Operator operator, Number num1, Number num2) {
        if (operator.value == '/' || num2.value == ZERO) {
            throw new IllegalArgumentException("잘못된 값이 들어왔습니다.");
        }
        return operate(operator.value, num1.value,num2.value);
    }
}
