import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.math.BigDecimal;
import java.util.ArrayList;

class Cal {


    public BigDecimal add(BigDecimal first, String second) {

        BigDecimal sec = new BigDecimal(second);
        return first.add(sec);
    }

    public BigDecimal sub(BigDecimal first, String second) {

        BigDecimal sec = new BigDecimal(second);
        return first.subtract(sec);
    }

    public BigDecimal mul(BigDecimal first, String second) {

        BigDecimal sec = new BigDecimal(second);
        return first.multiply(sec);
    }

    public BigDecimal div(BigDecimal first, String second) {

        BigDecimal sec = new BigDecimal(second);
        return first.divide(sec);
    }

    public String[] input() throws IOException {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str = bf.readLine();
            String arr[] = str.split(" ");
            return arr;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 입니다.");
        }
    }
    public void calculateStart(String[] str) {
        try {
            BigDecimal result = new BigDecimal(str[0]);
            if (str.length % 2 == 0) {
                throw new IllegalArgumentException("잘못된 입력 입니다.");
            }
            for (int i = 0; i < str.length - 2; i += 2) {
                result = cal(result, str[i + 2], str[i + 1].charAt(0));
            }
            System.out.println(result);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 입니다.");
        }


    }

    public BigDecimal cal(BigDecimal first, String second, char operator) {
        if (operator == '+') {
            return add(first, second);
        }
        if (operator == '-') {
            return sub(first, second);
        }
        if (operator == '/') {
            return div(first, second);
        }
        if (operator == '*') {
            return mul(first, second);
        }
        throw new IllegalArgumentException("잘못된 입력 입니다.");
    }
}
public class Calculator {
    public static void main(String[] args) throws IOException {
        Cal cal1 = new Cal();
        cal1.calculateStart(cal1.input());
    }
}
