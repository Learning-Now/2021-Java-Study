import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private String[] arrayFormula;

    public void inputFormula() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrayFormula = br.readLine().split(" ");
        for (int i = 1; i < arrayFormula.length; i += 2) {
            if (isElementInt(arrayFormula[i - 1]) == false || isElementInt(arrayFormula[i + 1])) {
                break;
            }
        }
    }

    private boolean isElementInt(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }
        catch(IllegalArgumentException e){
            System.out.println("입력된 값이 숫자가 아닙니다.");
            return false;
        }
    }

}