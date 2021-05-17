package utils;

public class SplitString {
    private static final String BOUNDARY_STRING= ",";
    private SplitString() {
    }

    public static String[] splitString(String input) {
        return input.split(BOUNDARY_STRING);
    }
}
