import domain.Number;
import view.InputView;

public class CalculatorApplication {
    private final InputView inputView;


    public CalculatorApplication(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        String value = inputView.nextValue();
        int number = inputView.nextInt();
        Number number1 = new Number(number);

        Number number2 = new Number(34);

        System.out.println("number1 = " + number1.getValue());


    }
}
