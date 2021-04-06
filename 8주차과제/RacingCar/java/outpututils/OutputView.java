package outpututils;

import racingcar.Car;

import java.util.Vector;

public class OutputView {
    private OutputView(){
    }
    public static void printCarName(String name){
            System.out.print(name+" : ");
    }

    public static void printMove(){
        System.out.print("-");
    }

    public static void printWinner(Vector<String> winner,int count){

        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if(i!=count-1)
            {
                System.out.print(", ");
            }
        }

    }

}
