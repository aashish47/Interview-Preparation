package LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if (A == null && B == null) {
            return null;
        }
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        ListNode tempA = A;
        ListNode tempB = B;

        int carry = 0;
        int sum = 0;
        sum = tempA.val + tempB.val + carry;
        carry = 0;
        if (sum > 9) {
            carry = 1;
            sum = sum % 10;
        }
        ListNode ans = new ListNode(sum);
        ListNode temp = ans;
        tempA = tempA.next;
        tempB = tempB.next;

        while (tempA != null && tempB != null) {
            sum = tempA.val + tempB.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = node;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        while (tempA != null) {
            sum = tempA.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = node;
            tempA = tempA.next;
        }
        while (tempB != null) {
            sum = tempB.val + carry;
            carry = 0;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = node;
            tempB = tempB.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            temp.next = node;
            temp = node;
        }
        return ans;
    }
}
