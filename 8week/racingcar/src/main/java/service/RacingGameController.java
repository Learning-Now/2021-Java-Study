package service;

import domain.Cars;
import domain.Number;

import utils.Input;
import utils.View;

import java.util.List;

public class RacingGameController {

    public Cars createCar() {
        List<String> carNames = Input.stringInput();
        return new Cars(carNames);
    }

    public Number createCount() {
        return Input.numberInput();
    }
}

