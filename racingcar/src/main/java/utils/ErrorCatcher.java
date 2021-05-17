package utils;

public class ErrorCatcher {
    private ErrorCatcher() {

    }

    public static void catchNameError(int nameLongCheck, boolean nameOnlyCheck) {
        if (nameOnlyCheck == false) {
            System.out.println("[ERROR] 중복된 이름이 있습니다.");
        }

        if (nameLongCheck != 0) {
            System.out.println("[ERROR] 이름의 길이가 부적절합니다.");
        }
    }
}
