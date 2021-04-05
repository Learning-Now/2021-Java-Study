package domain;

import utils.RandomUtils;

public class Engine {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int GO_POINT = 4;

    private Engine() {
        
    }
    
    public static boolean isPower() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE) >= GO_POINT;
    }
}
