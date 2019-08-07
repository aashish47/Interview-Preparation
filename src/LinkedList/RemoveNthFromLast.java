package LinkedList;

public class RemoveNthFromLast {
    public static ListNode removeNth(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        int ctr = 1;
        if (n >= count) {
            head = head.next;
        } else {
            temp = head;
            while (temp != null && ctr != count - n){
                temp = temp.next;
                ctr++;
            }
            temp.next = temp.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addNode(5);
        removeNth(head,3);
    }
}

