import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private String[] arrayFormula;
    private boolean isComputable = true;

    public void inputFormula() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        this.arrayFormula = br.readLine().split(" ");
        for (int i = 1; i < arrayFormula.length; i += 2) {
            if (isElementInt(arrayFormula[i - 1]) == false || isElementInt(arrayFormula[i + 1]) == false) {
                isComputable = false;
                break;
            }
        }
        if (isComputable) {
            Performer performer = new Performer(arrayFormula);
            performer.performCal();
        }
    }

    // 숫자가 들어가는 부분에 숫자가 들어갔는지 확인
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
