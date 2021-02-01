import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public String[] stringInput() throws IOException {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str = bf.readLine();
            return stringSplit(str);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다.");
        }
    }
    private String [] stringSplit(String str) throws IOException {
        try {
            String arr[] = str.split(" ");
            return arr;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("split 범위 오류");
        }
    }
}
