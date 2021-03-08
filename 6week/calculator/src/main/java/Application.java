import Service.CalculateStart;
import Service.StringInput;

import java.io.IOException;
import java.util.function.BiFunction;

public class Application {
    private static Object assertThat;

    public static void main(String[] args) throws IOException {
        final BiFunction<Integer ,Integer , Integer> bi = (num1, num2) -> num1+num2;
        int result = bi.apply(1,2);


        //CalculateStart calculateStart =new CalculateStart();
        //calculateStart.stringCalculateStart(new StringInput().stringInput());
    }
}
