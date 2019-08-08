package LinkedList;

public class SwapNodesAdjacent {
    public static ListNode swap(ListNode A){
        if(A == null || A.next == null){
            return A;
        }

        ListNode current = A;
        ListNode previous = null;
        ListNode forward;
        ListNode start = null;
        ListNode end = null;
        int flag = 0;
        int ctr = 0;
        while(current != null){
            start = end;
            end = current;
            ctr = 0;
            while(current != null && ctr != 2){
                forward = current.next;
                current.next = previous;
                previous = current;
                current = forward;
                ctr++;
            }
            if(flag == 0){
                flag = 1;
                A = previous;
            }
            if(start != null){
                start.next = previous;
            }
            end.next = current;
        }
        end.next = null;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addNode(5);
        head.addNode(6);
        head.addNode(7);
        swap(head);
    }
}
