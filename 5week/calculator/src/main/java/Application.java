import Service.CalStart;
import Service.StringInput;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        new CalStart().calculateStart(new StringInput().stringInput());
    }
}
