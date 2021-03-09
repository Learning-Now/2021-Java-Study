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
    public static final int FIND_FIRST_NUM = 0;
    public static final int FIND_OPERATOR = 1;
    public static final int FIND_SECOND_NUM = 2;

    public void start() {
        String[] arr = BufferInput.stringBufferInput();
        Number first = new Number(arr[FIND_FIRST_NUM]);
        Number result = new Number("0");

        for (int index = 0; index < arr.length - 2; index += 2) {
            Number second = new Number(arr[index + FIND_SECOND_NUM]);
            result = new Number(Operator.find(arr[index + FIND_OPERATOR]).calculate(first,second));
            first = result;
        }
        View.stringCalculatorResultView(result.getValue());
    }
}
