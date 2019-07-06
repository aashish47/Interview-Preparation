package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumSub {
    public static int maxSubArray(final List<Integer> A) {
        int max = Integer.MIN_VALUE;

        int currSum = 0;
        for(int i = 0; i < A.size(); i++){
            currSum += A.get(i);
            if(currSum > 0){
                max = Math.max(currSum, max);
            }
            else{
                currSum = 0;
            }
        }

        if(max == Integer.MIN_VALUE){
            Collections.sort(A);
            return A.get(A.size() - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        ArrayList<Integer> a = new ArrayList<>();
        for (int i : arr){
            a.add(i);
        }
        System.out.println(maxSubArray(a));
    }
}
