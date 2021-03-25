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
    public void start() {
        RacingCarGameController controller = new RacingCarGameController();
        List<Car> cars = controller.carSetting();
        int count = controller.countSetting();
        System.out.println(count);
        controller.run(count, cars);
        controller.findWinner(cars);
    }

}
