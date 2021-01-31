import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private String[] arrayFormula;
    private boolean isComputable = true;

    public void inputFormula() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        this.arrayFormula = br.readLine().split(" ");// 공백을 기준으로 연산자, 피연산자 구분 후 배열에 삽입
        for (int i = 1; i < arrayFormula.length; i += 2) {// 피연산자 중 숫자가 아닌 것이 있을 경우
            if (isElementInt(arrayFormula[i - 1]) == false || isElementInt(arrayFormula[i + 1]) == false) {
                isComputable = false;
                break;
            }
        }
        if (isComputable) {// 피연산자가 들어갈 부분에 모두 들어갔다면 연산 시작
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
        catch(IllegalArgumentException e){// 숫자로 변경이 불가한 경우
            System.out.println("입력된 값이 숫자가 아닙니다.");
            return false;
        }
    }

}
