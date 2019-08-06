package LinkedList;

public class DetectCycle {
    public static ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = a;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addCycle(2);
        System.out.println(detectCycle(head).val);
    }
}
