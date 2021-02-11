import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Formula {
    private String[] arrayFormula;
    private boolean isComputable = true;


    public void inputFormula() throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        this.arrayFormula = bufferedReader.readLine().split(" ");
    }

    Exception exception = new Exception();
    isComputable = exception.checkOperand(arrayFormula, isComputable);



}
