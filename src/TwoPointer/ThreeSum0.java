package TwoPointer;
import java.util.*;

public class ThreeSum0 {
    public static ArrayList<ArrayList<Integer>> threeSumZero(ArrayList<Integer> A) {

        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp;
        for(int i = 0; i < A.size() - 2; i++){
            int a = A.get(i);
            if(a > 0){
                break;
            }
            int start = i + 1;
            int end = A.size() - 1;
            while(start < end){
                int b = A.get(start);
                int c = A.get(end);

                if(a + b + c == 0){
                    temp = new ArrayList<>(Arrays.asList(a, b, c));
                    ans.add(temp);
                    while(start < end && A.get(start) == A.get(start + 1)){
                        start++;
                    }
                    start++;
                    while(start < end && A.get(end) == A.get(end - 1)){
                        end--;
                    }
                    end--;
                }
                else if (a + b + c > 0){
                    end--;
                }
                else{
                    start++;
                }
            }
            i++;
            while(i < A.size() - 2 && a == A.get(i)){
                i++;
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4));
        System.out.println(threeSumZero(A));
    }
}
