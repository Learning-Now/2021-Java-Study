package domain;

public class GameCounter {
    private int counter;

    public GameCounter(String round) {
        int number = validate(round);
        this.counter = number;
    }

    private int validate(String value) {
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
        if (result <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 자연수여야 한다.");
        }
        return result;
    }

    public int nextRound() {
        return counter--;
    }
}
