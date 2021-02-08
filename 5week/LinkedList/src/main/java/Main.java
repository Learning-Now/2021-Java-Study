
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
