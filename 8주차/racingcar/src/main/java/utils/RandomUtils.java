package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {

    }

    public static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive || startInclusive < 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 랜덤값 설정");
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }
}
