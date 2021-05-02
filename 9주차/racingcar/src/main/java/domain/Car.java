package domain;

public class Car {
    private static final String BLANK = " ";
    private static final int MAXIMAL_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(String name) {
        if (name.length() > MAXIMAL_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 한다.");
        }
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백은 포함하지 않아야 한다.");
        }
    }

    public boolean isSamePosition(Car car) {
        return car.position == this.position;
    }

    public int compareTo(Car car) {
        return this.position - car.position;
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
