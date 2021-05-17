package inpututils;

public class InputValidator {
    private static final int MAX_NAME = 5;

    public static void nameValidator(String name) {
        nullCheck(name);
        lengthCheck(name);
    }

    public static void nullCheck(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("[ERROR]자동차 이름을 입력해주세요.");
        }
    }

    public static void lengthCheck(String name) {
        if (name.length() > MAX_NAME) {
            throw new IllegalArgumentException("[ERROR]자동차 이름은 5자 이내여야합니다.");
        }
    }

}
