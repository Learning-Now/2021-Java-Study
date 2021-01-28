import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Operator {
    private static int sum;
    private static int num;

    public static void inputFormula() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = bf.readLine().split(" ");

        // 문자 입력 예외 처리
        try {
            sum = Integer.parseInt(arr[0]);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
        }

        executeCalc(arr);
    }

    public static void executeCalc(String[] arr) throws Exception {
        Calculator calculator = new Calculator();

        for (int i = 1; i < arr.length; i = i + 2) {
            // 문자 입력 예외 처리
            try {
                num = Integer.parseInt(arr[i + 1]);
            } catch (Exception e) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
            }

            // 계산
            if (arr[i].equals("+")) {
                sum = calculator.add(sum, num);
            } else if (arr[i].equals("-")) {
                sum = calculator.sub(sum, num);
            } else if (arr[i].equals("*")) {
                sum = calculator.mul(sum, num);
            } else if (arr[i].equals("/")) {
                sum = calculator.div(sum, num);
            }

            System.out.println(sum);
        }
        System.out.println("계산 값 : " + sum);
    }
}
