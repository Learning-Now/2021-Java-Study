import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Formula {
    private static String[] arrayFormula;
    private boolean isComputable = true;

    public void inputFormula() throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        this.arrayFormula = bufferedReader.readLine().split(" ");
        checkOperand();
    }

    public void checkOperand() throws IllegalArgumentException {
        for (int i = 1; i < arrayFormula.length; i += 2) {
            if (Exception.isElementInt(arrayFormula[i - 1]) == false ||
                    Exception.isElementInt(arrayFormula[i + 1]) == false) {
                isComputable = false;
                break;
            }
        }

        if (isComputable) {
            //FormulaRepository formulaRepository = new FormulaRepository();
            Performer performer = new Performer();
            performer.performCal();
        }
    }

    public static String[] getFormula() {
        return arrayFormula;
    }
}