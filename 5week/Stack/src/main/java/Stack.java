import org.omg.CORBA.ExceptionList;

public class Stack {
    private int [] arr;
    private int stackSize;
    private int dataSize;

    public Stack() {
        arr = new int[10]; // 0~9
        dataSize = 10;
        stackSize = 0;
    }
    public void push(int num) {
        if (stackSize == dataSize) {
            int [] tmp = new int[dataSize + 10];
            for (int i = 0 ; i < arr.length; i++) {
                tmp[i] = arr[i];
            }
            arr = tmp;
            dataSize = dataSize + 10;
            arr[stackSize] = num;
            stackSize++;
        } else {
            arr[stackSize] = num;
            stackSize++;
        }
    }

    public void pop() throws Exception {
        if (stackSize == 0) {
            throw new ArrayIndexOutOfBoundsException("Stack이 0 보다 작다");
        }
        System.out.println(arr[stackSize-1]);
        stackSize--;

    }
}