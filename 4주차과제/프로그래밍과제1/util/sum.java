package util;

public class sum {

    private String[] str_array;
    private int sum;

    public String[] split_String(String input) {
        str_array = input.split("\\s");
        return str_array;
    }

    public int to_Int(String str) {
        return Integer.parseInt(str);
    }

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

    public int calculate(String[] sps) {
        InputCheck(sps[0]);
        sum = to_Int(sps[0]);
        for (int i = 0; i < sps.length - 2; i += 2) {
            InputCheck(sps[i + 2]);
            if (sps[i + 1].equals("+")) {
                sum = add(sum, to_Int(sps[i + 2]));
            }
            if (sps[i + 1].equals("-")) {
                sum = sub(sum, to_Int(sps[i + 2]));
            }
            if (sps[i + 1].equals("*")) {
                sum = multi(sum, to_Int(sps[i + 2]));
            }
            if (sps[i + 1].equals("/")) {
                sum = div(sum, to_Int(sps[i + 2]));
            }

        }
        return sum;
    }

    public void InputCheck(String in) {
        try {
            to_Int(in);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닌 문자가 입력되었습니다.");
        }

    }

}
