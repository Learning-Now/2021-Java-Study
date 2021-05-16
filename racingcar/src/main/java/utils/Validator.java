package utils;

import java.util.Arrays;

public class Validator {
    private Validator() {

    }

    public static boolean isNameOnly(String[] carNames) {
         return (Arrays.asList(carNames))
                .stream()
                .distinct()
                .count() != (Arrays.asList(carNames)).size();
    }

    public static int isGoodLength(String[] carNames) {
        return (int)(Arrays.asList(carNames)
                .stream()
                .filter(x -> x.length() > 5)
                .count());
    }
}
