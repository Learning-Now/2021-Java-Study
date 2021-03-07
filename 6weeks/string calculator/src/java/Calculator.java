public class Calculator {
    public static double addNum(double a, double b) {
        return a + b;
    }

    public static double subNum(double a, double b) {
        return a - b;
    }

    public static double mulNum(double a, double b) {
        return a * b;
    }

    public static int divNum(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;
        }
    }
}
