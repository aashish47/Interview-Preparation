package Arrays;

public class SelectionSort {

    public static void swap(int []arr,int arr1, int arr2){
        int temp;
        temp = arr[arr1];
        arr[arr1] = arr[arr2];
        arr[arr2] = temp;
    }

    public static void sort(int []arr){
        for(int i = 0; i < arr.length - 1; i++){
            int small = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[small]){
                    small = j;
                }
            }
            swap(arr,small,i);
        }
    }

    public static void main(String[] args) {
        int []arr = {5,4,3,2,1};
        sort(arr);
        for (int num:arr) {
            System.out.println(num);
        }
    }
}
