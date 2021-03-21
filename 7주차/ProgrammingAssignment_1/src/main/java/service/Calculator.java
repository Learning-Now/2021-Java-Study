package service;

import domain.Number;
import domain.Operator;
import view.BufferedReaderInputView;
import view.PrinterOutputView;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    private static final int INDEX_INTERVAL_TWO = 2;

    public void start() {
        String[] formula = BufferedReaderInputView.input();
        Queue<Number> numbers = splitFormula(formula);
        Number resultNumber = numbers.poll();
        for (int index = 1; index < formula.length; index += INDEX_INTERVAL_TWO) {
            String stringResult = Operator.find(formula[index])
                    .calculate(resultNumber, numbers.poll());
            resultNumber = new Number(stringResult);
        }
        PrinterOutputView.printOutputView(resultNumber);
    }

    private Queue<Number> splitFormula(String[] formula) {
        return IntStream.range(0, formula.length)
                .filter(count -> count % 2 == 0)
                .mapToObj(index -> new Number(formula[index]))
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
