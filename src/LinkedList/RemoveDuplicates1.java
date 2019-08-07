package LinkedList;

public class RemoveDuplicates1 {
    public static ListNode removeDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode next;
        ListNode curr;
        while(temp != null){
            curr = temp;
            temp = temp.next;
            while(temp != null && curr.val == temp.val){
                temp = temp.next;
            }
            curr.next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(1);
        head.addNode(2);
        head.addNode(2);
        head.addNode(3);
        head.addNode(3);
        head.addNode(3);
        removeDuplicates(head);
    }
}
