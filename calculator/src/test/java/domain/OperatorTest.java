package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    void plusTest() {
        int result = Operator.plus(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void minusTest() {
        int result = Operator.minus(1, 2);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void divideTest() {
        int result = Operator.divide(1, 2);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void multiplyTest() {
        int result = Operator.multiply(1, 2);
        assertThat(result).isEqualTo(2);
    }
}
