import java.io.IOException;
import java.lang.IllegalArgumentException;

public class Exception {
/*
    private String[] formula;
    private boolean isComputable = true;

    public Exception() {
        this.formula = Formula.getFormula();
        this.isComputable = true;
    }
*/
    public static boolean isElementInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("입력된 값이 숫자가 아닙니다.");
            return false;
        }
    }
}