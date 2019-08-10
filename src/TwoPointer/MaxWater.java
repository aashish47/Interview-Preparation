package TwoPointer;
import java.util.*;
public class MaxWater {
    public static int maxWater(ArrayList<Integer> A){
        int max = 0;
        int i = 0;
        int j = A.size() - 1;
        while(i < j){
            max = Math.max(max, Math.min(A.get(i), A.get(j)) * (j - i));
            if(A.get(i) < A.get(j)){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,5,4,3));
        System.out.println(maxWater(A));
    }
}
