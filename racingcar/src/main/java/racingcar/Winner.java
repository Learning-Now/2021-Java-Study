package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> cars;
    private int maxPosition;

    public Winner(List<Car> cars, int maxPosition) {
        this.cars = cars;
        this.maxPosition = maxPosition;
    }

    public List<String> getWinnersName() {
        List<String> winnerName = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == maxPosition) {
                winnerName.add(cars.get(i).getName());
            }
        }
        return winnerName;
    }
}
