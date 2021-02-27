package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public String[] inputExpr() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] expr = br.readLine().split(" ");
        return expr;
    }
}