import org.omg.CORBA.ExceptionList;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.pop();
        stack.pop();
        stack.pop(); //
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}