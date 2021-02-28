package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    void calculateByPlusOperatorTest() {
       Operator operate = Operator.from("+");
       assertThat(operate.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    void calculateByMinusOperatorTest() {
        Operator operate = Operator.from("-");
        assertThat(operate.calculate(1, 2)).isEqualTo(-1);
    }

    @Test
    void calculateByDivideOperatorTest() {
        Operator operate = Operator.from("/");
        assertThat(operate.calculate(1, 2)).isEqualTo(0);
    }

    @Test
    void calculateByMultiplyOperatorTest() {
        Operator operate = Operator.from("*");
        assertThat(operate.calculate(1, 2)).isEqualTo(2);
    }
}
