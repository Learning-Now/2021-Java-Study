package service;

import domain.Cars;
import domain.Number;

import utils.Input;

public class RacingGameController {

    private RacingGameController() {};

    public static Cars createCar() {
        return Input.carNamesInput();
    }

    public static Number createCount() {
        return Input.numberInput();
    }
}

