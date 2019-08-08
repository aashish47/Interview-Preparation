package LinkedList;

public class MergeSort {

    public static ListNode divid(ListNode A){
        ListNode slow = A;
        ListNode fast = A;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }

    public static ListNode min(ListNode A, ListNode B){
        if(A == null){
            return B;
        }
        else if(B == null){
            return A;
        }
        else{
            return A.val > B.val ? B : A;
        }
    }

    public static ListNode merge(ListNode first, ListNode second){
        ListNode head = min(first,second);
        ListNode temp = head;
        if(head == null){
            return null;
        }

        first = head == first ? first.next : first;
        second = head == second ? second.next : second;

        while(first != null || second != null){
            ListNode minn = min(first, second);
            temp.next = minn;
            temp = minn;

            first = temp == first ? first.next : first;
            second = temp == second ? second.next : second;
        }
        return head;
    }

    public static ListNode mergeSort(ListNode A){
         ListNode B = divid(A);
         if(B == null){
             return A;
         }

         ListNode first = mergeSort(A);
         ListNode second = mergeSort(B);

         return merge(first, second);
    }

    public static ListNode sort(ListNode A){
        ListNode ans = mergeSort(A);
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(3);
        head.addNode(7);
        head.addNode(2);
        head.addNode(4);
        head.addNode(9);
        head.addNode(8);
        head.addNode(5);

        sort(head);
    }
}
