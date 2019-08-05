package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates2(ArrayList<Integer> a) {
        if (a.size() < 2) return a.size();
        int prev = a.get(a.size() - 1);
        for (int i = a.size() - 2; i >= 0; i--) {
            if (a.get(i) == prev) {
                a.remove(i);
            }
            else {
                prev = a.get(i);
            }
        }

        return a.size();
    }

    public static int removeDuplicates(ArrayList<Integer> a){
        if(a.size() == 1){
            return 1;
        }
        int j = 0;
        int i;
        int len = a.size();
        for(i = 0; i < a.size() - 1; i++){
            while(i < len - 1 && a.get(i).equals(a.get(i + 1))){
                i++;
            }
            if(i == len - 1){
                break;
            }
            int temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j,temp);
            j++;
        }
        if(j == 0){
            return ++j;
        }
        else if(a.get(len - 1) != a.get(j - 1)){
            int temp = a.get(len - 1);
            a.set(len - 1, a.get(j));
            a.set(j,temp);
            j++;
        }
        return j;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,1));
        int len = removeDuplicates(a);
        for(int i = 0; i < len; i++){
            System.out.print(a.get(i) + " ");
        }
    }
}
