public class Exception {

    public boolean checkOperand(String[] formula, boolean isComputable){
        for (int i = 1; i < formula.length; i += 2){
            if (isElementInt(formula[i - 1]) == false || isElementInt(formula[i + 1]) == false) {
                isComputable = false;
                break;
            }
        }
        return isComputable;
    }

    private boolean isElementInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("입력된 값이 숫자가 아닙니다.");
            return false;
        }
    }
}