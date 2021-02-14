import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Formula {
    private static String[] arrayFormula;
    private boolean isComputable;

    public void inputFormula() throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        this.arrayFormula = bufferedReader.readLine().split(" ");
        checkOperand();
    }

    public boolean checkOperand() throws IllegalArgumentException {
        for (int i = 1; i < arrayFormula.length; i += 2) {
            if (Exception.isElementInt(arrayFormula[i - 1]) == false || Exception.isElementInt(arrayFormula[i + 1]) == false) {
                isComputable = false;
                break;
            }
        }
        return isComputable;
    }

    public static String[] getFormula() {
        return arrayFormula;
    }

    Exception exception = new Exception();
}
