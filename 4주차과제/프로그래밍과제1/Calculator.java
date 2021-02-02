import input.input;
import util.sum;

public class Calculator{
    public static void main(String[] args) {

        String inputString;   // 입력 값 넣는 변수
        String[] strResultArray;    // 문자열 자른 후의 배열

        // 문자열 입력 받기
        input in = new input();
        inputString = in.InputString();

        // 문자열 자르기
        sum sps = new sum();
        strResultArray = sps.split_String(inputString);

        // 합계 계산 후 출력
        System.out.println("합계 : "+sps.calculate(strResultArray));

    }


}
