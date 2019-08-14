package Arrays;
import java.util.*;
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> pascal(int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        temp.add(1);
        ans.add(temp);
        if(n == 1){
            return ans;
        }

        for(int i = 1; i < n; i++){
            temp = new ArrayList<>();
            int j = 1;
            temp.add(1);
            while(temp.size() != i) {
                temp.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                j++;
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = pascal(10);
        for(int i = 0; i < ans.size(); i++){
            for(int j = 0; j < ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}
