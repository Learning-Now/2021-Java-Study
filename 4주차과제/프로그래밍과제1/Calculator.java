import input.input;
import util.sum;

public class Calculator{
    public static void main(String[] args) {

        String ip;   // 입력 값 넣는 변수
        String[] str_result;    // 문자열 자른 후의 배열
        int[] int_result;   // int로 바꾼 후의 배열

        // 문자열 입력 받기
        input in = new input();
        ip = in.InputString();

        // 문자열 자르기
        sum sps = new sum();
        str_result = sps.split_String(ip);

        // 합계 계산 후 출력
        System.out.println("합계 : "+sps.calculate(str_result));

    }


}
