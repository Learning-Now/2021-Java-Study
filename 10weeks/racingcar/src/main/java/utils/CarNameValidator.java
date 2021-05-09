package utils;

public class CarNameValidator {
    private CarNameValidator() {   }

    public static void validateName(String carName) {
        emptyCheck(carName);
        lengthCheck(carName);
    }

    public static void emptyCheck(String carName) {
        if (carName == "") {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력하지 않았습니다.");
        }
    }

    public static void lengthCheck(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로만 가능합니다.");
        }
    }
}
