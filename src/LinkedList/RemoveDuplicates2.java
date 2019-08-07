package LinkedList;

public class RemoveDuplicates2 {


    public static ListNode removeDuplicates(ListNode A){
        if(A == null || A.next == null){
            return A;
        }
        ListNode temp = A;
        ListNode curr;
        ListNode head = null;
        ListNode prev = null;
        int flag = 0;
        while(temp != null){
            int count = 0;
            curr = temp;
            temp = temp.next;
            while(temp != null && curr.val == temp.val){
                temp = temp.next;
                count += 1;
            }
            if(count == 0){
                if(flag == 0){
                    head = curr;
                    flag = 1;
                    prev = head;
                    temp = curr.next;
                }
                else{
                    prev.next = curr;
                    prev = curr;
                    temp = curr.next;
                }
            }
            else if(temp != null && temp.next != null && temp.val != temp.next.val){
                if(flag == 0){
                    head = temp;
                    flag = 1;
                    prev = head;
                    temp = temp.next;
                }
                else {
                    prev.next = temp;
                    prev = temp;
                    temp = temp.next;
                }
            }
            else if(temp != null && temp.next == null){
                if(flag == 0){
                    head = temp;
                    flag = 1;
                    prev = head;
                    temp = temp.next;
                }
                else{
                    prev.next = temp;
                    prev = temp;
                    temp = temp.next;
                }
            }

        }
        if(prev != null){
            prev.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(3);
        head.addNode(3);
        head.addNode(8);
        head.addNode(10);
        head.addNode(10);
        head.addNode(15);
        head.addNode(15);
        head.addNode(15);
        head.addNode(15);

        removeDuplicates(head);
    }
}
