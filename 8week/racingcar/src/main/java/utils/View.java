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

    public static void introView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void countView() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void runView() {
        System.out.println("실행결과");
    }

    public static void carStatusView(Car car) {
        View.carNameView(car.getName());
        View.distanceView(car.getPosition());
    }
}
