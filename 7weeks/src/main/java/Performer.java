public class Performer {
    private static String[] formula;
    private static double result = 0;
    private static int operator = 1;

    public Performer() {
        this.formula = Formula.getFormula();
    }

    public static void performCal() {// 계산수행
        for (operator = 1; operator < formula.length; operator += 2) {
            operateCal();
        }
        System.out.println("computed value : " + (int) result);// 형식을 맞추기 위해 정수형으로 캐스팅
    }

    public static void operateCal(){
        if (formula[operator].equals("+")) {
            performAdd();
        }
        if (formula[operator].equals("-")) {
            performSub();
        }
        if (formula[operator].equals("*")) {
            performMul();
        }
        if (formula[operator].equals("/")) {
            performDiv();
        }
        formula[operator + 1] = Double.toString(result);// 연산자 1개, 피연산자 2개가 아닐경우 연산을 계속 진행
    }

    public static void performAdd(){
        result = Calculator.addNum(Double.parseDouble(formula[operator - 1]),
                Double.parseDouble(formula[operator + 1]));// 연산에서 누락되는 것을 줄이기 위해 double
    }

    public static void performSub(){
        result = Calculator.subNum(Double.parseDouble(formula[operator - 1]),
                Double.parseDouble(formula[operator + 1]));
    }

    public static void performMul(){
        result = Calculator.mulNum(Double.parseDouble(formula[operator - 1]),
                Double.parseDouble(formula[operator + 1]));
    }

    public static void performDiv(){
        result = Calculator.divNum(Integer.parseInt(formula[operator - 1]),
                Integer.parseInt(formula[operator + 1]));
    }
}