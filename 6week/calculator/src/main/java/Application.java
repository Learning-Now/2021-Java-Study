import Service.CalculateStart;
import Service.StringInput;

import java.io.IOException;

public class Application {
    private static Object assertThat;

    public static void main(String[] args) throws IOException {


        CalculateStart calculateStart =new CalculateStart();
        calculateStart.stringCalculateStart(new StringInput().stringInput());
    }
}
