package util;

public class split {

    private String[] strArray; //  자른 후 String 배열

    public String[] splitString(String input) {
        strArray = input.split("\\s");
        return strArray;
    }
}
