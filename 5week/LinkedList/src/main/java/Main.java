
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
class LinkedList {
    private ListNode head;
    public LinkedList() {
        this.head = null;
    }
    public void Add(ListNode nodeToadd, int position) {
        ListNode pre = this.head;
        ListNode node = this.head;
        if (this.head != null) {
            for (int i = 0; i < position; i++) {
                pre = node;
                node = node.next;
            }
            pre.setNext(nodeToadd);
            nodeToadd.setNext(node);
        } else {
            this.head = nodeToadd;
        }
    }
    public void Remove(int positionToRemove) {
        ListNode pre = this.head;
        ListNode node = this.head;
        for (int i = 0 ; i < positionToRemove-1; i++) {
            pre = node;
            node = node.next;
        }
        pre.setNext(node.next);
    }
    public boolean Contains(ListNode nodeTocheck) {
        ListNode node = this.head;
        while (node.next != null) {
            if (node.next == nodeTocheck) {
                return true;
            } node = node.next;
        }
        return false;
    }
    public void View() {
        ListNode node = this.head;
        while (node != null) {
            System.out.println(node.getNode());
            node = node.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(7);
        linkedList.Add(listNode1, 0);
        linkedList.Add(listNode2, 1);
        linkedList.Add(listNode3, 2);
        linkedList.Remove(2);
        linkedList.Add(listNode4, 2);
        System.out.println(linkedList.Contains(listNode2));

        linkedList.View();

    }
}
