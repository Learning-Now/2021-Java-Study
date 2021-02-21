package domain;

public class Stack {

    private int[] stackArray;
    private int stackSize;
    private int top;
    private final int NEXTARGUMENT = 1;

    public Stack(int stackSize) {
        this.stackSize = stackSize;
        stackArray = new int[stackSize];
        this.top = 0;
    }

    private boolean isEmpty() {
        return top == 0;
    }

    private boolean isFull() {
        return top == stackSize;
    }

    public void push(int data) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("스택에 빈 공간이 없습니다.");
        }
        stackArray[top] = data;
        System.out.println(stackArray[top] + " push");
        this.top++;
    }

    public void pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("스택이 비어있습니다.");
        }
        this.top--;
        System.out.println(stackArray[top] + " pop");
    }

    public void print() {
        for (int i = 0; i < top; i += NEXTARGUMENT) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
}
