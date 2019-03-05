package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class DutchNationalFlag {
    public static void sort(ArrayList<Integer> arr, int index){
        int pivot = arr.get(index);
        int smaller = 0;
        int larger = arr.size();
        int equal = 0;

        while(equal < larger){
            if(arr.get(equal) < pivot){
                Collections.swap(arr,smaller++,equal++);
            }
            else if(arr.get(equal) == pivot){
                equal++;
            }
            else{
                Collections.swap(arr,equal,--larger);
            }
        }
    }

    public static void print(ArrayList<Integer> arr){
        for(int element: arr){
            System.out.print(element +" ");
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-3);
        arr.add(0);
        arr.add(-1);
        arr.add(1);
        arr.add(1);
        arr.add(-5);
        arr.add(4);
        arr.add(2);
        sort(arr,3);
        print(arr);
    }
}
