package Service;

import Domain.Operator;
import Domain.Number;

import java.math.BigDecimal;

public class CalStart {
    public void calculateStart(String[] str) {
        try {
            Number first = new Number(new BigDecimal(str[0]));
            if (str.length % 2 == 0) {
                throw new IllegalArgumentException("잘못된 입력 입니다.");
            }
            for (int i = 0; i < str.length - 2; i += 2) {
                Number second = new Number(new BigDecimal(str[i+2]));
                Operator operator = new Operator(str[i + 1].charAt(0));
                first.setNum(new Cal().cal(first, second, operator));
            }
            System.out.println(first.getNum());
        } catch (RuntimeException e) {
            throw new RuntimeException("잘못된 연산 입니다.");
        }
    }
}
