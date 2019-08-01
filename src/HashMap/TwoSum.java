package HashMap;

import java.util.*;

public class TwoSum {
    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < A.size(); i++){
            int curr = A.get(i);
            if(map.containsKey(B - curr)){
                int index = map.get(B - curr);
                ans.add(index);
                ans.add(i + 1);
                return ans;
            }

            else if(!map.containsKey(curr)){
                map.put(curr, i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8));
        System.out.println(twoSum(list, -3));
    }
}
