import domain.Stack;

public class main {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(6);
        stack.push(7);
        stack.print();
    }
}