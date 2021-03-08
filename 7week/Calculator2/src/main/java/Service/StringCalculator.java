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
    public static final int FIRST_NUM = 0;
    public static final int OPERATOR = 1;
    public static final int SECOND_NUM = 2;
    public void start() {
        String[] arr = BufferInput.stringBufferInput();
        Number first = new Number(arr[FIRST_NUM]);

        for (int index = 0; index < arr.length - 2; index += 2) {
            Number second = new Number(arr[index +SECOND_NUM]);
            first = new Number(Operator.from(arr[index + OPERATOR]).calculate(first,second));
        }
        View.stringCalculatorResultView(first.getValue());
    }
}
