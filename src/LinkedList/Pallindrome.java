package LinkedList;

public class Pallindrome {
    public static boolean checkPallindrome(ListNode A, ListNode B){
        while(A != null && B != null){
            if(A.val != B.val){
                return false;
            }
            A = A.next;
            B = B.next;
        }
        if(A != null || B != null){
            return false;
        }
        return true;
    }
    public static boolean isPallindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode forward;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;

        }

        if(fast.next == null){
            return checkPallindrome(previous,current.next);
        }
        else{
            forward = current.next;
            current.next = previous;
            return checkPallindrome(current, forward);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(3);
        head.addNode(2);
        head.addNode(1);
        System.out.println(isPallindrome(head));
    }
}
