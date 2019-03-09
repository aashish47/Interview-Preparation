package Arrays;

import java.util.ArrayList;

public class IncrementArray {
    public static void incerement(ArrayList<Integer> arr){
        Boolean isCarry = false;
        for(int i = arr.size() - 1; i >= 0; i--){
            if(i == arr. size() - 1){
                arr.set(i,arr.get(i) + 1);
            }

            if(isCarry){
                arr.set(i,arr.get(i) + 1);
                isCarry = false;
            }


            if(arr.get(i) == 10){
                isCarry = true;
                arr.set(i,0);
            }

            if(i == 0 && arr.get(i) == 0){
                arr.set(i,0);
                arr.add(0,1);
            }
        }
    }
    public static void print(ArrayList<Integer> arr){
        for(Integer element : arr){
            System.out.print(element + " ");
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(9);
        arr.add(9);
        incerement(arr);
        print(arr);

    }
}
