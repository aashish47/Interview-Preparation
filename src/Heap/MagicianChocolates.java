package Heap;

import java.util.*;

public class MagicianChocolates {
    public static int maxchoco(ArrayList<Integer> bag, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(bag);
        q.addAll(bag);
        long sum = 0;
        for(int i = 0; i < k; i++){
            int curr = q.poll();
            if(curr < 1){
                break;
            }
            sum += curr;
            sum = sum % 1000000007;
            q.add(curr/2);
        }
        return (int)sum % 1000000007;
    }

    public static void main(String[] args) {
        ArrayList<Integer> bag = new ArrayList<>(Arrays.asList(6,5));
        System.out.println(maxchoco(bag, 3));
    }
}

