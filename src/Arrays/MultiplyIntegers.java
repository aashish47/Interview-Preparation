package Arrays;

import java.util.ArrayList;

public class MultiplyIntegers {
    public static ArrayList<Integer> multiply(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> tempResult = new ArrayList<>();
        for(int i = arr2.size() - 1; i > 0; i--){
            for(int j = arr1.size() - 1; i > 0; i--){

            }
        }
        return result;
    }

    public static ArrayList<Integer> convertToArr(int x){
        ArrayList<Integer> arr = new ArrayList<>();
        while(x > 0){
         int i = x % 10;
         x = x /10;
         arr.add(i);
        }
        int leftIndex = 0;
        int rightIndex = arr.size() - 1;
        while(leftIndex < rightIndex){
            int temp = arr.get(leftIndex);
            arr.set(leftIndex,arr.get(rightIndex));
            arr.set(rightIndex,temp);
            leftIndex++;
            rightIndex--;
        }
        return arr;
    }

    public static void print(ArrayList<Integer> arr){
        for(Integer element : arr){
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        int a = 31;
        int b = 29 ;
        ArrayList<Integer> arr1 = convertToArr(a);
        ArrayList<Integer> arr2 = convertToArr(b);
        ArrayList<Integer> result = multiply(arr1,arr2);
        print(arr2);
    }
}
