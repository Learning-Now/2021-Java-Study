package Domain;


import java.math.BigDecimal;

public class Number {
    private BigDecimal value;
    private static final BigDecimal ZERO = new BigDecimal(0);

    public Number(String value) {
        this.value = validateNumber(value);
    }

    public Number(BigDecimal value) {
        this.value = value;
    }

    private BigDecimal validateNumber(String value) {
        try {
            return new BigDecimal(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public BigDecimal getValue() {
        return value;
    }


}
