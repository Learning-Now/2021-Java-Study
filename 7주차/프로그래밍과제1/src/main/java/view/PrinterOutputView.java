package view;

import domain.Number;

public class PrinterOutputView{

    private PrinterOutputView() {
    }

    public static void printOutputView(Number result) {
        System.out.println("계산 값 : " + result.getValue());
    }
}
