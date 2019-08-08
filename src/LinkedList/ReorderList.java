package LinkedList;

import java.util.ArrayList;

public class ReorderList {
    public static ListNode reorder(ListNode A){
        if(A == null || A.next == null || A.next.next == null){
            return A;
        }
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode temp = A;
        while(temp != null){
            nodes.add(temp);
            temp = temp.next;
        }
        int i = 0;
        int j = nodes.size() - 1;
        temp = nodes.get(i++);
        A = temp;
        temp.next = nodes.get(j--);
        temp = temp.next;
        while(i <= j){
            temp.next = nodes.get(i++);
            temp = temp.next;
            if(i > j){
                break;
            }
            temp.next = nodes.get(j--);
            temp = temp.next;
        }
        temp.next = null;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addNode(5);
        head.addNode(6);

        reorder(head);
    }
}
