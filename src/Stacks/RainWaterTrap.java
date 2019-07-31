package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrap {
    public static int trap(final List<Integer> A) {
        int[] left = new int[A.size()];
        left[0] = 0;
        int[] right = new int[A.size()];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < A.size(); i++){
            max = Math.max(A.get(i - 1), max);
            left[i] = max;

        }
        max = Integer.MIN_VALUE;
        for(int i = A.size() - 2; i >= 0; i--){
            max = Math.max(A.get(i + 1), max);
            right[i] = max;
        }
        right[A.size() - 1] = 0;

        int sum = 0;
        for(int i = 0; i < A.size(); i++){
            sum += Math.max(Math.min(left[i], right[i]) - A.get(i), 0);
        }
        return sum;
    }

    public static int trap2(final List<Integer> A) {

        int a = 0;
        int b = A.size() - 1;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int res = 0;
        while (a <= b) {
            maxLeft = Math.max(A.get(a), maxLeft);
            maxRight = Math.max(A.get(b), maxRight);
            if (maxLeft <= maxRight) {
                res += maxLeft - A.get(a);
                a++;
            } else {
                res += maxRight - A.get(b);
                b--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1));
        System.out.println(trap(arr));
    }

}
