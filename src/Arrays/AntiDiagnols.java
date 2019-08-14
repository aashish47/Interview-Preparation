package Arrays;
import java.util.*;
public class AntiDiagnols {
    public static ArrayList<ArrayList<Integer>> diagnols(ArrayList<ArrayList<Integer>> A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp;
        for(int i = 0; i < A.size(); i++){
            temp = new ArrayList<>();
            for(int j = 0, k = i; k >=0 && j < A.size(); j++, k--){
                temp.add(A.get(j).get(k));
            }
            ans.add(temp);
        }
        for(int i = 1; i < A.size(); i++){
            temp = new ArrayList<>();
            for(int j = i, k = A.size() - 1; k >=0 && j < A.size(); j++, k--){
                temp.add(A.get(j).get(k));
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(1,2,3)));
        a.add(new ArrayList<>(Arrays.asList(4,5,6)));
        a.add(new ArrayList<>(Arrays.asList(7,8,9)));
        a = diagnols(a);
        System.out.println(a);
    }
}
