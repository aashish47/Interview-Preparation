package LinkedList;

public class InsertionSort {
    public static ListNode sort(ListNode A){
        if(A == null || A.next == null){
            return A;
        }
        ListNode temp = A;
        ListNode prev = A;
        ListNode current = A.next;
        ListNode head = A;
        ListNode tail = A;
        ListNode forward;
        while(current != null){
            forward = current.next;
            if(current.val < temp.val){
                head = current;
                current.next = temp;
            }
            else if(current.val >= tail.val){
                tail = current;
            }
            else{
                head = temp;
                while (temp != null && current.val > temp.val && temp != current) {
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = current;
                current.next = temp;
            }
            current = forward;
            temp = head;
            prev = head;
            tail.next = current;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(1);
        head.addNode(1);
        head.addNode(1);
        head.addNode(1);
        head.addNode(1);
        head.addNode(1);
        head.addNode(1);
        sort(head);
    }
}
