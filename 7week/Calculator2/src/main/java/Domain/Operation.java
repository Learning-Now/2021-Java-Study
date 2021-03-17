package Domain;

import java.math.BigDecimal;
import java.util.ArrayDeque;

public interface Operation {
    BigDecimal calculate(ArrayDeque<Number> numbers);

}
