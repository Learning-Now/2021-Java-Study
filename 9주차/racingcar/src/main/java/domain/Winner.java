package domain;

public class Winner {
    private final Car winner;

    public Winner(Car winner) {
        this.winner = winner;
    }

    public String getWinnerName() {
        return winner.getName();
    }
}
