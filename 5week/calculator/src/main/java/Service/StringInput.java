package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringInput {
    public String[] stringInput() throws IOException {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str = bf.readLine();
            return new StringSplit(str).getArr();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다.");
        }
    }

}
