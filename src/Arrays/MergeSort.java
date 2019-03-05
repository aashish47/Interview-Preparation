package Arrays;

public class MergeSort {

    public static void merge(int []arr1, int []arr2, int arr3[]){
        int i = 0, j = 0, k = 0;
        for(;i < arr1.length && j < arr2.length;) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            }
            if (arr1[i] > arr2[j]) {
                arr3[k++] = arr2[j++];
            }
        }
        while(i < arr1.length){
            arr3[k++] = arr1[i++];
        }
        while(j < arr2.length){
            arr3[k++] = arr2[j++];
        }
    }
    public static void mergeSort(int arr[]){
        if(arr.length <= 1){
            return;
        }
        int mid = arr.length/2;
        int left[] = new int[mid];
        int right[] = new int[arr.length - mid];
        for(int i = 0; i < left.length; i++){
            left[i] = arr[i];
        }
        for(int i = 0; i < right.length; i++){
            right[i] = arr[mid + i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);

    }
    public static void main(String[] args) {
        int []arr = {5,4,3,2,1};
        mergeSort(arr);
        for (int num:arr) {
            System.out.println(num);
        }
    }
}
