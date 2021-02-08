
public class ListNode {
    private int num;
    public ListNode next;

    ListNode(int num) {
        this.num = num;
        this.next = null;
    }

    public int getNode() {
        return this.num;
    }
    public void addNext(ListNode next) {
        this.next = next;
    }

}