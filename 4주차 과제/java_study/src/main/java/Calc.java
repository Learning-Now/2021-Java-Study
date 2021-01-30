import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
    private static double result = 0;
    private static boolean CheckNum1 = true;
    private static boolean CheckNum2 = true;
    private static int op = 1; //연산자 Index

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        for(op = 1; op < str.length; op += 2){
            CheckNum1 = isStringDouble(str[op - 1]);
            if(CheckNum1 == false){
                break;
            }
            CheckNum2 = isStringDouble(str[op + 1]);
            if(CheckNum2 == false){
                break;
            }
            if(str[op].equals("+")){
                result = add(Double.parseDouble(str[op - 1]),Double.parseDouble(str[op + 1]));
            }
            if(str[op].equals("-")){
                result = sub(Double.parseDouble(str[op - 1]),Double.parseDouble(str[op + 1]));
            }
            if(str[op].equals("*")){
                result = mul(Double.parseDouble(str[op - 1]),Double.parseDouble(str[op + 1]));
            }
            if(str[op].equals("/")){
                result = div(Double.parseDouble(str[op - 1]),Double.parseDouble(str[op + 1]));
            }
            str[op + 1] = Double.toString(result);
        }
        if((CheckNum1 == true) && (CheckNum2 == true)){
            System.out.println("계산 값 : " + (int)result);
        }

    }

    private boolean isStringDouble(String str){
        try{
            Double.parseDouble(str);
            return true;
        } catch(IllegalArgumentException e){
            System.out.println("숫자가 아닌 문자가 입력되었습니다.");
            return false;
        }
    }

    private double add(double first_value, double second_value){
        return first_value + second_value;
    }

    private double sub(double first_value, double second_value){
        return first_value - second_value;
    }

    private double mul(double first_value, double second_value){
        return first_value * second_value;
    }

    private double div(double first_value, double second_value){
        return first_value / second_value;
    }
}
