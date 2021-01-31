public class Performer {
    private static String[] formula;
    private static double result = 0;// 연산 도중 값을 저장하고 최후에 결과값을 저장함

    public Performer() {}
    public Performer(String[] formula) {// 생성자. 인스턴스 생성과 동시에 formula 값 세팅
        this.formula = formula;
    }

    public static void performCal(){// 계산수행
        for (int operator = 1; operator < formula.length; operator += 2) {
            if (formula[operator].equals("+")) {
                result = CalculateNum.addNum(Double.parseDouble(formula[operator - 1]),
                        Double.parseDouble(formula[operator + 1]));// 연산에서 누락되는 것을 줄이기 위해 double
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
                result = CalculateNum.divNum(Integer.parseInt(formula[operator - 1]),
                        Integer.parseInt(formula[operator + 1]));
            }
            formula[operator + 1] = Double.toString(result);// 연산자 1개, 피연산자 2개가 아닐경우 연산을 계속 진행
        }
        System.out.println("computed value : " + (int)result);// 형식을 맞추기 위해 정수형으로 캐스팅
    }
}
