package Utility;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BufferSplit {
    private BufferSplit(){};

    public static String[] stringGapSplit(String str) {
        try {
            return str.split(" ");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("split 범위 오류");
        }

    }

}
