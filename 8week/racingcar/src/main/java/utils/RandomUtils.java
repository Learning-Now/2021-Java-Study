package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int randomIntGenerator(final int startNumber, final int lastNumber) {
        if (startNumber > lastNumber) {
            throw new IllegalArgumentException();
        }
        if (startNumber < 0) {
            throw new IllegalArgumentException();
        }
        if (startNumber == lastNumber) {
            return startNumber;
        }
        return startNumber + RANDOM.nextInt(lastNumber - startNumber + 1);
    }

}
