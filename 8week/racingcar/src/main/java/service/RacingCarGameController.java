package service;

import domain.Car;
import domain.Cars;

import utils.Input;
import utils.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingCarGameController {
    private final static int ZERO = 0;
    private int times;

    public Cars createCar() {
        String [] carNames = Input.stringInput();
        return new Cars(Arrays.stream(carNames)
                .map(carName -> new Car(carName))
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public void setTimes() {
        times = Input.intInput();
    }

    public void run(Cars cars) {
        setTimes();
        for (int time = ZERO; time < times; time++){
            cars.moveCars();
            System.out.println();
        }
        View.resultView(cars.getWinner());
    }

}
