package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortByColor {
    public static void sort(ArrayList<Integer> color){
        int i = 0;
        int j = color.size() - 1;

        for(int k = 0; k <= j; k++){
            int curr = color.get(k);
            if(curr == 0){
                Collections.swap(color, k, i);
                if(k != i){
                    k--;
                }
                i++;

            }
            else if(curr == 2){
                Collections.swap(color, k, j);
                if(k != j){
                    k--;
                }
                j--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> color = new ArrayList<>(Arrays.asList(0, 2, 2, 0, 0, 2, 1, 2, 0, 1, 1, 2, 0, 2, 2, 0, 1, 0, 0, 1, 1, 2, 1, 0, 0, 0, 2, 1, 1, 2, 1, 0, 2, 2, 1, 2, 1, 1, 1, 1, 1, 0, 0, 0, 2, 0, 1, 0, 2, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 2, 1, 0, 2, 1, 0, 2, 0, 0, 2, 2, 1, 2, 2, 2, 1, 0, 0, 0, 2, 2, 1, 0, 1, 1, 0, 2, 0, 1, 2, 2, 2, 0, 2, 1, 0, 1, 2, 0, 2, 2, 0, 2, 1, 1, 2, 1, 2, 0, 2, 2, 2, 1, 2, 0, 1, 1, 1, 0, 1, 0, 1, 2, 2, 1, 1, 0, 2, 2, 1, 2, 2, 1, 0, 0, 0, 1, 1, 1, 2, 0, 2, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 2, 1, 1, 1, 2, 0, 2, 0, 2, 0, 0, 0, 1, 1, 0, 1, 2, 0, 2, 1, 0, 0, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 0, 0, 1, 2, 2, 1, 0, 1, 2, 0, 1, 0, 2, 2, 0, 0, 1, 1, 1, 0, 0, 0, 2, 2, 2, 0, 2, 1, 0, 1, 2, 0, 0, 0, 2, 1, 2, 2, 1, 2, 2, 1, 2, 0, 1, 0, 1, 2, 1, 2, 0, 1, 1, 2, 2, 1, 1, 2, 1, 2, 2, 1, 2, 2, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 2, 1, 2, 0, 2, 1, 1, 0, 1, 0, 2, 1, 2, 2, 1, 2, 0, 0, 2, 0, 0, 2, 0, 0, 1, 2, 0, 0, 0, 1, 0, 2, 1, 0, 1, 0, 1, 2, 0, 2, 0, 1, 1, 2, 1, 0, 0, 2, 0, 2, 0, 0, 0, 0, 1, 2, 2, 2, 0, 0, 1, 1, 2, 0, 0, 0, 1, 2, 1, 2, 2, 0, 0, 1, 0, 2, 0, 2, 1, 2, 1, 2, 2, 0, 1, 2, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 2 ));
        sort(color);
        System.out.println(color);
    }
}
