import java.util.ArrayList;

class Queue {
    private ArrayList<Integer> arr = new ArrayList<>();

    public void push(int num) {
        arr.add(num);
    }

    public int pop() {
        if (arr.size() == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int tmp;
            tmp = arr.get(0);
            arr.remove(0);
            System.out.println(tmp);
            return tmp;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.pop();
    }
}
