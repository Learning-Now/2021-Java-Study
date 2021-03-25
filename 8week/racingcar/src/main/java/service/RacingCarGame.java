package service;

import domain.Car;
import utils.Input;
import utils.Sort;
import utils.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winner = new ArrayList<>();
    private final static int ZERO = 0;
    private int count = 0;
    private int maxPosition = 0;

    public void start() {
        gameSetting();
        run(this.count, cars);
        getResult(cars);
    }

    public void gameSetting() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String [] carNames = Input.stringInput();
        Arrays.stream(carNames)
                .forEach(carName -> cars.add(new Car(carName)));
        System.out.println("시도할 회수는 몇회인가요?");
        this.count = Input.intInput();
    }

    public void getResult(List<Car> cars) {
        List<Car> sortedCars = Sort.sortList(cars);
        findMaxPosition(sortedCars);
        for (Car car : sortedCars) {
            if (maxPosition == car.getPosition()) {
                winner.add(car);
            }
        }
        View.resultView(winner);
    }


    public void findMaxPosition(List<Car> sortedcars) {
        this.maxPosition = sortedcars.get(ZERO).getPosition();
    }

    public void run(int count, List<Car> cars) {
        System.out.println("실행결과");
        for (int times = ZERO; times < count; times++){
            for (Car car : cars) {
                car.movePosition();
                View.carNameView(car.getName());
                View.distanceView(car.getPosition());
            }
            System.out.println();
        }
    }

}
