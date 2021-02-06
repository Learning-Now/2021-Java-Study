
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
class Stack {
    private ListNode head;
    public Stack() {
        this.head = null;
    }
    public void add(ListNode nodeToadd) {
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
        ListNode pre = this.head;
        ListNode node = this.head;
        while (node.next != null) {
            pre = node;
            node = node.next;
        }
        System.out.println(node.getNode());
        pre.setNext(null);
    }
}

public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(7);
        stack.add(listNode1);
        stack.add(listNode2);
        stack.add(listNode3);
        stack.add(listNode4);
        stack.pop();
        stack.pop();
    }
}
