package Service;

import Domain.Number;
import Domain.Operator;
import Utility.BufferInput;
import Utility.View;

import java.util.ArrayDeque;


public class StringCalculator {
    private StringCalculator(){};

    public static void start() {
        String[] arr = BufferInput.BufferInputAndGapSplit();
        ArrayDeque<Number> numbers = splitArr(arr);

        Number result = new Number("0");
        
        for (int index = 1; index < arr.length; index += 2) {
            result = new Number(Operator.find(arr[index]).calculate(numbers));
            numbers.addFirst(result);
        }
        View.stringCalculatorResultView(result.getValue());
    }

    public static ArrayDeque<Number> splitArr(String [] arr) {
        ArrayDeque<Number> numbers = new ArrayDeque<>();
        for (int index = 0; index < arr.length; index += 2) {
            numbers.add(new Number(arr[index]));
        }
        return numbers;
    }
}
