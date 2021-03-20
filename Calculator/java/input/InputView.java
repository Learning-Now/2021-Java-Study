package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public String[] inputFormula() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] formula = br.readLine().split(" ");
        return formula;
    }
}