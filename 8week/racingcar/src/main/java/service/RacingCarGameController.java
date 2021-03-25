package service;

import domain.Car;
import utils.Input;
import utils.Sort;
import utils.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGameController {
    private final static int ZERO = 0;
    protected final List<Car> cars = new ArrayList<>();
    private final List<Car> winner = new ArrayList<>();
    protected int count;
    private int maxPosition = 0;

    public void carSetting() {
        View.introView();
        String [] carNames = Input.stringInput();
        Arrays.stream(carNames)
                .forEach(carName -> cars.add(new Car(carName)));
    }

    public void countSetting() {
        View.countView();
        count = Input.intInput();
    }

    public void findMaxPosition(List<Car> sortedcars) {
        this.maxPosition = sortedcars.get(ZERO).getPosition();
    }

    public void findWinner(List<Car> cars) {
        List<Car> sortedCars = Sort.sortList(cars);
        findMaxPosition(sortedCars);
        for (Car car : sortedCars) {
            if (maxPosition == car.getPosition()) {
                winner.add(car);
            }
        }
        View.resultView(winner);
    }

    public void run(int count, List<Car> cars) {
        View.runView();
        for (int times = ZERO; times < count; times++){
            carStatus(cars);
            System.out.println();
        }
    }

    private void carStatus(List<Car> cars) {
        for (Car car : cars) {
            car.movePosition();
            View.carStatusView(car);
        }
    }

}
