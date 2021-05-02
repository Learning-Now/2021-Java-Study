package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Car> cars;
    private int maxPosition;

    public Winners(List<Car> cars, int maxPosition) {
        this.cars = cars;
        this.maxPosition = maxPosition;
    }

    public List<String> getWinnersName() {
        List<String> winnerName = new ArrayList<>();

        winnerName = cars.stream()
                .filter(x -> x.getPosition() == maxPosition)
                .map(x -> x.getName())
                .collect(Collectors.toList());

        return winnerName;
    }
}