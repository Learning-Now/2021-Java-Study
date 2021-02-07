
public class Test {
    public static int result = 0;
    public void recursivefunction(int num) {
        if (result < 10) {
            result = result + num;
            recursivefunction(num);
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.recursivefunction(1);
        System.out.println(result);
    }
}
