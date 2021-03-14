import service.Calculator;
import view.BufferedReaderInputView;

public class Application {

    public static void main(String[] args) {
        Calculator.start(BufferedReaderInputView.input());
    }
}