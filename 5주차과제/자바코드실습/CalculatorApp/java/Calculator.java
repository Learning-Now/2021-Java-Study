import input.input;
import util.split;
import util.calculate;
import util.inputCheck;

public class Calculator {
    public static void main(String[] args) {
        // 변수 선언
        String inputString;   // 입력 값
        String[] strResultArray;    // 문자열 자른 후의 배열

        // 문자열 입력 받기
        input in = new input();
        inputString = in.InputString();

        // 문자열 자르기
        split sp = new split();
        strResultArray = sp.splitString(inputString);

        // 합계 계산 후 출력
        calculate c = new calculate();
        System.out.println("합계 : " + c.calculate(strResultArray));

    }
}
