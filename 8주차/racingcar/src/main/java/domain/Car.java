package domain;

public class Car {
    private static final String BLANK = " ";
    private static final int MAXIMAL_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAXIMAL_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 한다.");
        }
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백은 포함하지 않아야 한다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        position++;
    }
}
