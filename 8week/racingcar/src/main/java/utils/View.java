package utils;

import domain.Car;

import java.util.List;

public class View {

    private View() {};

    public static void distanceView(final int positon) {
        for (int count = 0; count < positon; count ++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void carNameView(final String name){
        System.out.print(name + " : ");
    }

    public static void resultView(final List<Car> cars){
        System.out.print("최종 우승자 : ");
        for (int index = 0; index< cars.size(); index++) {
            if (index+1 == cars.size()) {
                System.out.print(cars.get(index).getName());
                break;
            }
            System.out.print(cars.get(index).getName() + ", ");
        }
    }
}
