package domain;

public class GameCounter {
    private static final int ZERO = 0;

    private int counter;

    public GameCounter(String round) {
        validate(round);
        this.counter = Integer.parseInt(round);
    }

    private void validate(String value) {
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
        if (result <= ZERO) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 자연수여야 한다.");
        }
    }

    public int nextRound() {
        return counter--;
    }
}
