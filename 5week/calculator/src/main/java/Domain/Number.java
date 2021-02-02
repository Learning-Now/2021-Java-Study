package Domain;

import java.math.BigDecimal;

public class Number {
    private BigDecimal value;


    public Number(BigDecimal value) {
        this.value = value;
        validateNumber();
    }

    private void validateNumber() {
        if(this.value == new BigDecimal(0) ){
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
