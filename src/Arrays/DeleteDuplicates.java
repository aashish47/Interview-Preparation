package Arrays;

import java.util.ArrayList;

public class DeleteDuplicates {
    public static ArrayList<Integer> deleteDuplicates(ArrayList<Integer> arr){
        if(arr.size() == 0){
            return null;
        }

        int writeIndex = 1;
        for(int i = 1; i < arr.size(); i++){
            if(!arr.get(writeIndex - 1).equals(arr.get(i))){
                arr.set(writeIndex++,arr.get(i));
            }
        }
        for(int i = arr.size() - 1 ; i >= writeIndex; i--){
            arr.remove(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr = deleteDuplicates(arr);
        for(Integer i : arr){
            System.out.println(i);
        }
    }
}
