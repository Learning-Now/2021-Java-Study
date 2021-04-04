package domain;

public class Car {
    public static final String BLANK = " ";
    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > 5) {
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
