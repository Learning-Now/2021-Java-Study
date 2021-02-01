import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IntInput input = new IntInput();
        Cal cal1 = new Cal();
        View view = new View();
        view.print(cal1.calculateStart(input.input()));

    }
}
