package Service;

import java.io.IOException;

public class StringSplit {
    private final String [] arr;
    public StringSplit(String str) throws IOException {
        try {
            this.arr = str.split(" ");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("split 범위 오류");
        }
    }

    public String[] getArr() {
        return this.arr;
    }
}
