public class Exam01 {
    public static void main(String[] args) {
        int numberOne = 2_000_000_000;
        int numberTwo = 2_100_000_000;

        int average1 = (numberTwo + numberOne) / 2;

        int average2 = numberOne + (numberTwo - numberOne) / 2;

        int average3 = (numberTwo + numberOne) >> 1;

        int average4 = (numberTwo + numberOne) >>> 1;

        System.out.println("average1 = " + average1);

        System.out.println("average2 = " + average2);

        System.out.println("average3 = " + average3);

        System.out.println("average3 = " + average4);
    }
}


