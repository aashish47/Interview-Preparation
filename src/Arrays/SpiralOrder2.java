package Arrays;
import java.util.*;
public class SpiralOrder2 {
    public static ArrayList<ArrayList<Integer>> spiral(int n){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                temp.add(0);
            }
            arr.add(temp);
        }
        int left = 0;
        int right = n;
        int top = 0;
        int bottom = n;
        int ctr = 0;
        int i = 0;
        int j = 0;
        while(count != (n * n) + 1){
            for(; j < right; j++){
                arr.get(i).set(j, count++);
            }
            j--;
            i++;
            top++;
            for(; i < bottom; i++){
                arr.get(i).set(j, count++);
            }
            right--;
            j--;
            i--;
            for(; j >= left ; j--){
                arr.get(i).set(j, count++);
            }
            bottom--;
            j++;
            i--;
            for(; i >= top; i--){
                arr.get(i).set(j, count++);
            }
            left++;
            j++;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = spiral(5);
        for(int i =0; i < ans.size(); i++){
            for(int j = 0; j < ans.size(); j++){
                System.out.print(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}
