package LinkedList;

public class RotateList {
    public static ListNode rotate(ListNode A, int n){
        if(A == null || n == 0 || A.next == null){
            return A;
        }
        int count = 1;
        ListNode temp = A;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        temp = A;
        int ctr = 1;
        if(n % count == 0){
            return A;
        }
        while(ctr != count - (n % count)){
            temp = temp.next;
            ctr++;
        }
        ListNode head = temp.next;
        temp.next = null;
        temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = A;
        return head;
    }
}
