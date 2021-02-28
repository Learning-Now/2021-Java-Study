package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class OperandTest {

    @DisplayName("피연산자 정상 생성 테스트")
    @Test
    void operandGenerateTest() {
        assertThatCode(() -> new Operand(3))
                .doesNotThrowAnyException();
    }

    @DisplayName("피연산자 반환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, -1, 4})
    void operandReturnValueTest(int value) {
        Operand operand = new Operand(value);

        assertThat(operand.getValue()).isEqualTo(value);
    }
}
