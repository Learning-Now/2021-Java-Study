import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Cal cal1 = new Cal();
        View view = new View();
        view.print(cal1.calculateStart(input.stringInput()));

    }
}
