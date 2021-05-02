package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final String DELIMITER = ", ";

    private List<Winner> winners;

    public Winners(List<Winner> winners) {
        this.winners = new ArrayList<>(winners);
    }

    public String winnersToString() {
        return winners.stream()
                .map(Winner::getWinnerName)
                .collect(Collectors.joining(DELIMITER));
    }
}
