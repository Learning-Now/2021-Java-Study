import org.omg.CORBA.ExceptionList;

import java.util.ArrayList;

class Stack {
    private ArrayList<Integer> intList = new ArrayList<>();

    public void push(int num) {
        this.intList.add(num);
    }

    public int pop() {
        if (intList.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("배열이 비여있음 ");
        } else {
            int tmp = intList.get(intList.size()-1);
            System.out.println(intList.get(intList.size()-1));
            intList.remove(intList.size()-1);
            return tmp;
        }
    }
}

public class Main {
    public static void main(String[] args) {
       Stack stack1 = new Stack();
       stack1.push(1);
       stack1.push(2);
       stack1.push(3);
       stack1.push(4);
       stack1.pop();
       stack1.pop();
       stack1.pop();
       stack1.pop();
       stack1.pop();

    }
}
