package Arrays;

import java.util.ArrayList;

public class AdvancingArray {
    public static boolean canReachEnd(ArrayList<Integer> arr){
        int lastIndex = arr.size() - 1;
        int furthestReachSoFar = 0;

        for(int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; i++){
            furthestReachSoFar = Math.max(furthestReachSoFar,arr.get(i) + i);
        }
        return furthestReachSoFar >= lastIndex;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(3);
        arr.add(1);
        arr.add(0);
        arr.add(2);
        arr.add(0);
        arr.add(1);
        System.out.println(canReachEnd(arr));

    }
}
