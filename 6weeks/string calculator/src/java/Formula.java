import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Formula {
    private static String[] arrayFormula;
    private boolean isComputable = true;
    private int i = 1;

    public void inputFormula() throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        this.arrayFormula = bufferedReader.readLine().split(" ");
        startCheckOperand();
    }

    public void startCheckOperand() throws IllegalArgumentException {
        for (i = 1; i < arrayFormula.length; i += 2) {
            checkOperand();
        }
        startPerformer();
    }

    public void checkOperand(){
        if (Exception.isElementInt(arrayFormula[i - 1]) == false ||
                Exception.isElementInt(arrayFormula[i + 1]) == false) {
            System.out.println("입력된 값 중 " + arrayFormula[i - 1] + "또는 " +
                    arrayFormula[i + 1] + "이 숫자가 아닙니다.");
            isComputable = false;
        }
    }

    public void startPerformer() {
        if (isComputable) {
            Performer performer = new Performer();
            performer.performCal();
        }
    }

    public static String[] getFormula() {
        return arrayFormula;
    }
}