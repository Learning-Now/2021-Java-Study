package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars){
        validate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validate(List<Car> cars){

    }
}
