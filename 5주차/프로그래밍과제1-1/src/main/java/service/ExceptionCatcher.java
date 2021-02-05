package service;

import java.util.Arrays;

public class ExceptionCatcher {

    public int catchWrongNumber(String formularArguement) {

        int number;

        try {
            number = Integer.parseInt(formularArguement);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 입력되었습니다.");
        }

        return number;
    }


    public String catchWrongString(String formularArguement) {

        String[] operators = {"+", "-", "*", "/"};

        if (!(formularArguement.getClass().getName().equals("java.lang.String"))) {
            throw new IllegalArgumentException("잘못된 연산자가 입력되었습니다.");
        }

        if (!(Arrays.asList(operators).contains(formularArguement))) {
            throw new IllegalArgumentException("지원하지 않는 연산자가 입력되었습니다.");
        }

        return formularArguement;
    }
}
