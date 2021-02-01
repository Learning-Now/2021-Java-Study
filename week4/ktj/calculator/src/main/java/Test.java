public class Test {

    // TODO numbers 라는 Int 형 배열이 있다.
    //  해당 배열에 들어있는 숫자들은 오직 한 숫자를 제외하고는 모두 두번씩 들어있다.
    //  오직 한 번만 등장하는 숫자를 찾는 코드를 작성하라.
    public static void main(String[] args) {
        Test exam02 = new Test();

        int result = exam02.solution(new int[]{5, 4, 3, 2, 1, 2, 3, 4, 5});
        int result2 = exam02.solution(new int[]{5, 3, 3, 3, 3, 3, 3, 3, 3});
        System.out.println("result = " + result);
        System.out.println("result2 =  " + result2);
    }

    public int solution(int[] numbers) {
        int result = 0;
        int[] a = new int[5];
        int temp;

        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            a[temp - 1]++;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1){
                result = i + 1;
            }
        }
        return result;
    }
}