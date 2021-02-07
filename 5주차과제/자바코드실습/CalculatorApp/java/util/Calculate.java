package util;
import util.toInt;
import util.operator;

public class Calculate{
    private int sum;

    public int calculate(String[] sps){
        operator op = new operator();
        toInt ti = new toInt();
        inputCheck ic = new inputCheck();

        ic.InputCheck(sps[0]);  // 0번째 값이 숫자인지 확인
        sum = ti.toInt(sps[0]);
        for (int i = 0; i < sps.length - 2; i += 2) {
            ic.InputCheck(sps[i + 2]);  // 2,4,6 등 짝수 번째 인덱스가 숫자인지 확인
            if (sps[i + 1].equals("+")) {   // 1,3,5 등 홀수 번째 인덱스가 연산자와 같을 때
                sum = op.add(sum, ti.toInt(sps[i + 2]));
            }
            if (sps[i + 1].equals("-")) {
                sum = op.sub(sum, ti.toInt(sps[i + 2]));
            }
            if (sps[i + 1].equals("*")) {
                sum = op.multi(sum, ti.toInt(sps[i + 2]));
            }
            if (sps[i + 1].equals("/")) {
                sum = op.div(sum, ti.toInt(sps[i + 2]));
            }
        }
        return sum;
    }
}
