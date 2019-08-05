package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfArrays {
    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0, j = 0; i < a.size() && j < b.size();){
            int currA = a.get(i);
            int currB = b.get(j);
            if(currA < currB){
                i++;
            }
            else if(currB < currA){
                j++;
            }
            else{
                i++;
                j++;
                ans.add(currA);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 3, 5));
        System.out.println(intersection(a, b));
    }
}
