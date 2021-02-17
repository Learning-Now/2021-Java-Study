package Domain;

import java.math.BigDecimal;

public class Number {
    private BigDecimal value;
    private static final BigDecimal zero = new BigDecimal(0); //잉? 바꿔놨는디

    public Number(BigDecimal value) {
        this.value = value;
        validateNumber();
    }

    private void validateNumber() {
        if(this.value == zero ){
            throw new IllegalArgumentException("잘못된 값이 들어왔습니다.");
        }
    }

    public BigDecimal getNum() {
        return this.value;
    }
    public void setNum(BigDecimal value) {
        this.value = value;
    }
}
