package Domain;

import java.math.BigDecimal;

public class Number {
    protected BigDecimal value;
    private static final BigDecimal ZERO = new BigDecimal(0);

    public Number(BigDecimal value) {
        this.value = value;
        validateNumber();
    }

    private void validateNumber() {
        if(this.value == ZERO ){
            throw new IllegalArgumentException("잘못된 값이 들어왔습니다.");
        }
    }

    public BigDecimal getValue() {
        return value;
    }


}
