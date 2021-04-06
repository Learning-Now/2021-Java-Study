package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<Winner> winners;
    private static final String DELIMITTER = ", ";

    public Winners(List<Winner> winners) {
        this.winners = new ArrayList<>(winners);
    }

    public String winnersToString() {
        return winners.stream()
                .map(Winner::getWinnerName)
                .collect(Collectors.joining(DELIMITTER));
    }
}
