package utils;

public class SplitString {
    private SplitString() {
    }

    public static String[] splitString(String input) {
        return input.split(",");
    }
}
