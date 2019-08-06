package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }

    public void addNode(int x){
        ListNode node = new ListNode(x);
        ListNode temp = this;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addCycle(int x) {
        ListNode temp = this;
        ListNode cycle = this;
        int flag = 0;
        while (temp.next != null) {
            if (flag == 0 && temp.val == x) {
                cycle = temp;
                flag = 1;
            }
            temp = temp.next;
        }
        if (flag == 0) {
            temp.next = temp;
        } else {
            temp.next = cycle;
        }
    }
}
