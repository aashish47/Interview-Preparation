package Arrays;

import java.util.ArrayList;

public class KthRowPascal {
    public static ArrayList<Integer> pascal(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        if (n == 0) {
            return temp;
        }
        if (n == 1) {
            temp.add(1);
            return temp;
        }

        for (int i = 1; i <= n; i++) {
            temp = new ArrayList<>();
            int j = 1;
            temp.add(1);
            while (temp.size() != i) {
                temp.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
                j++;
            }
            temp.add(1);
            ans.add(temp);
        }
        return temp;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ans = pascal(3);
        System.out.println(ans);
    }
}
