import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.math.BigDecimal;

public class Cal {
        private BigDecimal add(BigDecimal first, String second) {
            BigDecimal sec = new BigDecimal(second);
            return first.add(sec);
        }

        private BigDecimal sub(BigDecimal first, String second) {
            BigDecimal sec = new BigDecimal(second);
            return first.subtract(sec);
        }

        private BigDecimal mul(BigDecimal first, String second) {
            BigDecimal sec = new BigDecimal(second);
            return first.multiply(sec);
        }

        private BigDecimal div(BigDecimal first, String second) {
            BigDecimal sec = new BigDecimal(second);
            return first.divide(sec);
        }


        public BigDecimal calculateStart(String[] str) {
            try {
                BigDecimal result = new BigDecimal(str[0]);
                if (str.length % 2 == 0) {
                    throw new IllegalArgumentException("잘못된 입력 입니다.");
                }
                for (int i = 0; i < str.length - 2; i += 2) {
                    result = cal(result, str[i + 2], str[i + 1].charAt(0));
                }
                return result;
            } catch (RuntimeException e) {
                throw new RuntimeException("잘못된 연산 입니다.");
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
            throw new RuntimeException("런타임 에러");
        }
}


