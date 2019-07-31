package Queues;

import java.util.*;

public class SlidingWindowMaximum {
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        for(; i < B; i++){
            while(!deque.isEmpty() && A.get(i) > A.get(deque.peekLast())){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        ans.add(A.get(deque.peekFirst()));
        for(; i < A.size(); i++){
            while(!deque.isEmpty() && deque.peekFirst() <= i - B){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast())){
                deque.removeLast();
            }

            deque.addLast(i);
            ans.add(A.get(deque.peekFirst()));
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        System.out.println(slidingMaximum(arr , 2));
    }
}
