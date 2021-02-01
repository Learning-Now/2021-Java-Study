public class Exam02 {

    // TODO numbers라는 Int형 배열이 있다.
    //  해당 배열에 들어있는 숫자들은 오직 한 숫자를 제외하고는 모두 두번씩 들어있다.
    //  오직 한 번만 등장하는 숫자를 찾는 코드를 작성하라.
    public static void main(String[] args) {
        Exam02 exam02 = new Exam02();

        int result = exam02.solution(new int[]{5, 4, 3, 2, 1, 2, 3, 4, 5});
        int result2 = exam02.solution(new int[]{5, 3, 3, 3, 3, 2, 2, 1, 1});
        System.out.println("result = " + result);       // 1
        System.out.println("result2 = " + result2);     // 5
    }

    /**
     * 5 ^ 0 = 5
     * 101
     * 000
     * ---
     * 101
     *
     * 5 ^ 5 = 0
     * 101
     * 101
     * ---
     * 000
     */
    public int solution(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result ^= number;
        }
        return result;
    }
}
