package Arrays;

public class BubbleSort {
    public static void swap(int []arr,int arr1, int arr2){
        int temp;
        temp = arr[arr1];
        arr[arr1] = arr[arr2];
        arr[arr2] = temp;
    }

    public static void sort(int []arr){
        int flag = 1;
        for(int i = 0; i < arr.length - 1; i++){
            flag = 1;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                    flag = 0;
                }
            }
            if(flag == 1){
                return;
            }
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
