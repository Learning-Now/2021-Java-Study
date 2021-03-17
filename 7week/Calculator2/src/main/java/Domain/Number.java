package Domain;


import java.math.BigDecimal;
import java.util.ArrayList;

public class Number {
    private BigDecimal value;

    public Number(String value) {
        validateNumber(value);
        this.value = stringToBigDecimal(value);
    }

    public Number(BigDecimal value) {
        this.value = value;
    }

    private void validateNumber(String value) {
        try {
            new BigDecimal(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private BigDecimal stringToBigDecimal (String value) {
        return new BigDecimal(value);
    }

    public BigDecimal getValue() {
        return value;
    }

}
