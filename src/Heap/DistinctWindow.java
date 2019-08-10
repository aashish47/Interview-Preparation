package Heap;
import java.util.*;
public class DistinctWindow {
    public static ArrayList<Integer> distinct(ArrayList<Integer> A, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        if(k > A.size()){
            return ans;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i, j;
        for(i = 0; i < k; i++){
            if(map.containsKey(A.get(i))){
                map.put(A.get(i), map.get(A.get(i)) + 1);
            }
            else{
                map.put(A.get(i), 1);
            }
        }
        ans.add(map.size());
        for(j = 0; j < A.size() - k ; j++){
            int pop = A.get(j);
            int push = A.get(i++);

            if(map.get(pop) == 1){
                map.remove(pop);
            }
            else{
                map.put(pop, map.get(pop) - 1);
            }
            if(map.containsKey(push)){
                map.put(push, map.get(push) + 1);
            }
            else{
                map.put(push, 1);
            }
            ans.add(map.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3));
        System.out.println(distinct(A, 3));
    }
}
