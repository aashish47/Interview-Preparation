package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElement {
    public static int remove(ArrayList<Integer> a, int b){
        int j = 0;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) != b){
                a.set(j,a.get(i));
                j++;
            }
        }
        int len = a.size();
        for(int i = 0; i < len - j; i++){
            a.remove(a.size() - 1);
        }
        return j;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,1,1,2,1,1,1,3,4,1,2,3));
        System.out.println(remove(arr, 1));
        for(int i: arr){
            System.out.print(i);
        }
    }
}
