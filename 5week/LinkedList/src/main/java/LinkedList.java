public class LinkedList {

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
            pre.addNext(nodeToadd);
            nodeToadd.addNext(node);
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
        pre.addNext(node.next);
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
