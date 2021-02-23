package service;

public class FormulaSplitter {

    public int splitNumber(String formularArguement) {
        try {
            int number = Integer.parseInt(formularArguement);
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
        }
    }
}
