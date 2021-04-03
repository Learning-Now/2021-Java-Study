package utils;

import java.util.HashMap;
import java.util.Map;

public class Validator {
    public static int[] validateName(String[] carNames) {
        int[] validationResult = {0, 0};

        // index 0에 이름 중복 검사 결과
        // index 1에 이름 길이 검사 결과
        validationResult[0] = isNameOnly(carNames);

        for (int i = 0; i < carNames.length; i++) {
            String name = carNames[i];

            if (isNameLong(name)) {
                validationResult[1] = 1;
                break;
            }
        }
        return validationResult;
    }

    public static boolean isNameLong(String name) {
        if (name.length() > 5) {
            return true;
        }
        return false;
    }

    public static int isNameOnly(String[] carNames) {
        Map<String, String> nameCount = new HashMap<String, String>();

        for (int i = 0; i < carNames.length; i++) {
            if (nameCount.containsKey(carNames[i])) {
                return 1;
            }
            nameCount.put(carNames[i], "이것은 존재한.");
        }
        return 0;
    }
}
