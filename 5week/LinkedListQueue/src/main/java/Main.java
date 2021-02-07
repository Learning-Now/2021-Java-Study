
class ListNode {
    private int num;
    public ListNode next;

    ListNode(int num) {
        this.num = num;
        this.next = null;
    }

    public int getNode() {
        return this.num;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }

}
class Queue {
    private ListNode head;
    public Queue() {
        this.head = null;
    }
    public void push(ListNode nodeToadd) {
        ListNode node = this.head;
        if (this.head == null) {
            this.head = nodeToadd;
        } else {
            while(node.next != null) {
                node = node.next;
            }
            node.setNext(nodeToadd);
        }
    }
    public void pop() {
        ListNode node = this.head;
        if (this.head.next == null) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            System.out.println(node.getNode());
            this.head = this.head.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Queue queue = new Queue();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(7);
        queue.push(listNode1);
        queue.push(listNode2);
        queue.push(listNode3);
        queue.push(listNode4);
        queue.pop();
        queue.pop();
    }
}
