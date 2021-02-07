package util;

public class operator {

    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int multi(int i, int j) {
        return i * j;
    }

    public int div(int i, int j) {
        try {
            return i / j;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("나눌 수 없습니다.");
        }
    }
}
