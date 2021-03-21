import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Formula {
    private static String[] arrayFormula;
    private int checkIndex = 1;

    public void inputFormula() throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        this.arrayFormula = bufferedReader.readLine().split(" ");
    }

    public void startCheckOperand() throws IllegalArgumentException {
        boolean isComputable = true;
        for (checkIndex = 1; checkIndex < arrayFormula.length + 1; checkIndex += 2) {
            isComputable = isOperandComputable();
            if (isComputable == false){
                break;
            }
        }
        startPerformer(isComputable);
    }

    public boolean isOperandComputable() {
        if (Exception.isElementInt(arrayFormula[checkIndex - 1]) == false) {
            System.out.println("숫자가 아닌 값: " + arrayFormula[checkIndex - 1]);
            return false;
        }
        return true;
    }

    public void startPerformer(boolean isComputable) {
        if (isComputable) {
            Performer performer = new Performer();
            performer.performCal();
        }
    }

    public static String[] getFormula() {
        return arrayFormula;
    }
}