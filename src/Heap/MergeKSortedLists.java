package Heap;

import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class listCompare implements Comparator<ListNode>{
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode merge(ArrayList<ListNode> A){
        if(A.size() == 0 ){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new listCompare());
        ListNode temp;
        for(int i = 0; i < A.size(); i++){
            temp = A.get(i);
            while(temp != null){
                queue.add(temp);
                temp = temp.next;
            }
        }
        ListNode head = queue.poll();
        temp = head;
        while (!queue.isEmpty()){
            temp.next = queue.poll();
            temp = temp.next;
        }
        return head;
    }
}
