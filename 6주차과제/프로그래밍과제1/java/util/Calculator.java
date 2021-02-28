package util;
import input.InputUtils;
public class Calculator {
    private int sum;

    Operator op = new Operator();
    ToInt ti = new ToInt();
    InputCheck ic = new InputCheck();

    public void checkFirstInput(String[] sps){
        ic.InputCheck(sps[0]);  // 0번째 값이 숫자인지 확인
        sum = ti.toInt(sps[0]);
    }

    public void calculatePlus(String[] sps){
        for (int i = 0; i < sps.length - 2; i += 2) {
            ic.InputCheck(sps[i + 2]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + 1].equals("+")) {   // 1,3,5 등 홀수 번째 인덱스가 연산자와 같을 때
                sum = op.add(sum, ti.toInt(sps[i + 2]));
            }
        }
    }

    public void calculateSubtraction(String[] sps){
        for (int i = 0; i < sps.length - 2; i += 2) {
            ic.InputCheck(sps[i + 2]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + 1].equals("-")) {
                sum = op.sub(sum, ti.toInt(sps[i + 2]));
            }
        }
    }

    public void calculateMultiplication(String[] sps){
        for (int i = 0; i < sps.length - 2; i += 2) {
            ic.InputCheck(sps[i + 2]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + 1].equals("*")) {
                sum = op.multi(sum, ti.toInt(sps[i + 2]));
            }
        }
    }

    public void calculateDivision(String[] sps){
        for (int i = 0; i < sps.length - 2; i += 2) {
            ic.InputCheck(sps[i + 2]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + 1].equals("/")) {
                sum = op.div(sum, ti.toInt(sps[i + 2]));
            }
        }
    }


    public int calculate(String[] sps) {
        //첫번째 값 확인
        checkFirstInput(sps);
        //연산자에 따라 계산
        calculatePlus(sps);
        calculateSubtraction(sps);
        calculateMultiplication(sps);
        calculateDivision(sps);

        return sum;
    }

    public void run(){
        // 변수 선언
        String inputString;   // 입력 값
        String[] strResultArray;    // 문자열 자른 후의 배열

        // 문자열 입력 받기
        InputUtils in = new InputUtils();
        inputString = in.getNextLine();

        // 문자열 자르기
        SplitString sp = new SplitString();
        strResultArray = sp.splitString(inputString);

        // 합계 계산 후 출력
        Calculator c = new Calculator();
        System.out.println("합계 : " + c.calculate(strResultArray));
    }
}
