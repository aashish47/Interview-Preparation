package LinkedList;

public class PartitionList {
    public static ListNode partition(ListNode A, int n){
        if(A == null || A.next == null){
            return A;
        }
        ListNode previous = null;
        ListNode current = A;
        ListNode forward;
        ListNode nextInsert = null;
        ListNode nextInsertNext = A;
        ListNode head = A;
        while(current != null){
            if(current.val < n){
                if(nextInsert != null && nextInsert.next != current){
                    previous.next = current.next;
                    forward = current.next;
                    nextInsertNext = nextInsert.next;
                    nextInsert.next = current;
                    nextInsert = current;
                    current.next = nextInsertNext;
                    current = forward;
                }
                else if(nextInsert != null && nextInsert.next == current){
                    nextInsert = current;
                    previous = current;
                    current = current.next;
                }
                else{
                    if(previous == null){
                        head = current;
                        nextInsert = current;
                        previous = current;
                        current = current.next;
                    }
                    else{
                        head = current;
                        nextInsert = current;
                        forward = current.next;
                        previous.next = current.next;
                        current.next = nextInsertNext;
                        current = forward;
                    }

                }
            }
            else{
                previous = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addNode(5);

        partition(head, 5);
    }
}
