package outpututils;

import java.util.ArrayList;

public class OutputView {
    private OutputView() {
    }
    public static void printCarName(String name) {
        System.out.print(name + " : ");
    }

    public static void printMove() {
        System.out.print("-");
    }

    public static void printWinner(ArrayList<String> winner) {
        //TODO:마지막에 , 나오지 않도록 수정 필요
        winner.stream()
                .forEach(w -> System.out.print(w + ","));
    }
}
