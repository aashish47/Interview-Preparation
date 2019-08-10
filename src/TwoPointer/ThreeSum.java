package TwoPointer;
import java.util.*;
public class ThreeSum {
    public int threeSumClosest(ArrayList<Integer> A, int B) {

        Collections.sort(A);

        int min = Integer.MAX_VALUE;
        int res = -1;
        for(int i = 0; i < A.size() - 2; i++){
            int a = A.get(i);
            int start = i + 1;
            int end = A.size() - 1;
            while(start < end){
                int b = A.get(start);
                int c = A.get(end);

                if(Math.abs(B - (a + b + c)) < min){
                    min = Math.abs(B - (a + b + c));
                    res = a + b + c;
                }
                if(a + b + c == B){
                    return B;
                }
                else if (a + b + c > B){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return res;
    }
}
