package Arrays;

public class InsertionSort {
    public static void sort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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
