package Service;

import Domain.Number;
import Domain.Operator;
import Utility.BufferInput;
import Utility.View;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
    public static final int FIND_INDEX_ZERO = 0;
    public static final int INDEX_INTERVAL_ONE = 1;
    public static final int INDEX_INTERVAL_TWO = 2;

    public void start() {
        String[] arr = BufferInput.stringBufferInput();
        Number first = new Number(arr[FIND_INDEX_ZERO]);
        Number result = new Number("0");

        for (int index = 0; index < arr.length - 2; index += 2) {
            Number second = new Number(arr[index + INDEX_INTERVAL_TWO]);
            result = new Number(Operator.find(arr[index + INDEX_INTERVAL_ONE]).calculate(first,second));
            first = result;
        }
        View.stringCalculatorResultView(result.getValue());
    }
}
