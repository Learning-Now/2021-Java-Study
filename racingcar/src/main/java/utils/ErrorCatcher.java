package utils;

public class ErrorCatcher {
    public static void CatchNameError(int[] nameErrors) {
        if (nameErrors[0] == 1) {
            System.out.println("[ERROR] 중복된 이름이 있습니다.");
        }

        if (nameErrors[1] == 1) {
            System.out.println("[ERROR] 이름의 길이가 부적절합니다.");
        }
    }
}
