
public class Main {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(7);
        linkedList.add(listNode1, 0);
        linkedList.add(listNode2, 1);
        linkedList.add(listNode3, 2);
        linkedList.remove(2);
        linkedList.add(listNode4, 2);
        System.out.println(linkedList.contains(listNode2));

        linkedList.view();

    }
}
