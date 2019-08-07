package LinkedList;

public class MeregeTwoLists {
    public static ListNode merge(ListNode A, ListNode B){
        if(A == null && B == null){
            return null;
        }
        if(A == null){
            return B;
        }
        if(B == null){
            return A;
        }

        ListNode tempA = A;
        ListNode tempB = B;
        ListNode ans;
        if(A.val > B.val){
            ans = new ListNode(B.val);
            tempB = tempB.next;
        }
        else{
            ans = new ListNode(A.val);
            tempA = tempA.next;
        }
        ListNode tempAns = ans;


        while(tempA != null && tempB != null){
            if(tempA.val > tempB.val){
                tempAns.next = new ListNode(tempB.val);
                tempB = tempB.next;
            }
            else{
                tempAns.next = new ListNode(tempA.val);
                tempA = tempA.next;
            }
            tempAns = tempAns.next;
        }
        while(tempA != null){
            tempAns.next = new ListNode(tempA.val);
            tempA = tempA.next;
            tempAns = tempAns.next;
        }
        while(tempB != null){
            tempAns.next = new ListNode(tempB.val);
            tempB = tempB.next;
            tempAns = tempAns.next;
        }
        return ans;
    }
}
