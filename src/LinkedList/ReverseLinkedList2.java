package LinkedList;

public class ReverseLinkedList2 {
    public static void reverse(ListNode head, int m, int n){
        if(head == null || m == n){
            return;
        }
        ListNode temp1 = head;
        ListNode current = head;
        int i = 1;
        ListNode M;
        if(m == 1){
            M = temp1;
        }
        else{
            while(i != m - 1){
                temp1 = temp1.next;
                i++;
            }
            i++;
            M = temp1.next;
        }

        current = M;
        ListNode previous = null;
        ListNode forward;
        while(i != n){
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
            i++;
        }
        M.next = current.next;
        current.next = previous;
        if(m != 1){
            temp1.next = current;
        }
        else{
            head = current;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2);
        head.addNode(3);
//        head.addNode(4);
//        head.addNode(5);
        reverse(head,1,2);
        System.out.println();
    }
}
