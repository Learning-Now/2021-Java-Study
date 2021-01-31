public class Performer {
    private static String[] formula;
    private static double result = 0;

    public Performer() {}
    public Performer(String[] formula) {
        this.formula = formula;
    }

    public static void performCal(){
        for (int operator = 1; operator < formula.length; operator += 2) {
            if (formula[operator].equals("+")) {
                result = CalculateNum.addNum(Double.parseDouble(formula[operator - 1]),
                        Double.parseDouble(formula[operator + 1]));
            }
            if (formula[operator].equals("-")) {
                result = CalculateNum.subNum(Double.parseDouble(formula[operator - 1]),
                        Double.parseDouble(formula[operator + 1]));
            }
            if (formula[operator].equals("*")) {
                result = CalculateNum.mulNum(Double.parseDouble(formula[operator - 1]),
                        Double.parseDouble(formula[operator + 1]));
            }
            if (formula[operator].equals("/")) {
                result = CalculateNum.divNum(Double.parseDouble(formula[operator - 1]),
                        Double.parseDouble(formula[operator + 1]));
            }
            formula[operator + 1] = Double.toString(result);
        }
        System.out.println("computed value : " + (int)result);
    }
}
