package service;

import domain.Cars;
import domain.Number;

import utils.Input;

public class RacingGameController {

    public Cars createCar() {
        return Input.carNamesInput();
    }

    public Number createCount() {
        return Input.numberInput();
    }
}

