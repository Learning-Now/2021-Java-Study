package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferInput {
    private BufferInput() {};

    public static String[] BufferInputGapSplit() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str = bf.readLine();
            return str.split(" ");
        } catch (IOException e){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
