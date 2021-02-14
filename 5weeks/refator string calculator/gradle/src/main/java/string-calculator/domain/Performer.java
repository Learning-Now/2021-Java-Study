public class Performer {
    private static String[] formula;
    private static double result = 0;

    public Performer(){
        this.formula = Formula.getFormula();
    }

    public static void performCal(){// 계산수행
        for (int operator = 1; operator < formula.length; operator += 2) {
            if (formula[operator].equals("+")) {
                result = Calculator.addNum(Double.parseDouble(formula[operator - 1]),
                        Double.parseDouble(formula[operator + 1]));// 연산에서 누락되는 것을 줄이기 위해 double
            }
            if (formula[operator].equals("-")) {
                result = Calculator.subNum(Double.parseDouble(formula[operator - 1]),
                        Double.parseDouble(formula[operator + 1]));
            }
            if (formula[operator].equals("*")) {
                result = Calculator.mulNum(Double.parseDouble(formula[operator - 1]),
                        Double.parseDouble(formula[operator + 1]));
            }
            if (formula[operator].equals("/")) {
                result = Calculator.divNum(Integer.parseInt(formula[operator - 1]),
                        Integer.parseInt(formula[operator + 1]));
            }
            formula[operator + 1] = Double.toString(result);// 연산자 1개, 피연산자 2개가 아닐경우 연산을 계속 진행
        }
        System.out.println("computed value : " + (int)result);// 형식을 맞추기 위해 정수형으로 캐스팅
    }
}
