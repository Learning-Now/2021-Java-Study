package Service;
import Domain.Number;

import java.math.BigDecimal;

public class CalculateOperation {
    BigDecimal add(Number first, Number second) {
        return first.getNum().add(second.getNum());
    }

    BigDecimal sub(Number first, Number second) {
        return first.getNum().subtract(second.getNum());
    }

    BigDecimal mul(Number first, Number second) {
        return first.getNum().multiply(second.getNum());
    }

    BigDecimal div(Number first, Number second) {
        return first.getNum().divide(second.getNum());
    }
}
