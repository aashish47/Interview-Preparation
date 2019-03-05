package Arrays;

public class ArrayRotation {

    public static int[] rotateArray(int[] arr, int d, int n){
        int temp[] = new int[n];
        int count = 0;
        for(int i = d; i < n; i++){
            temp[i - d] = arr[i];
        }
        for(int i = 0; i < d; i++){
            temp[n - d + i] = arr[i];
        }
        return temp;
    }

    static void leftRotate(int arr[], int d)
    {
        int n = arr.length;
        rvereseArray(arr, 0, d-1);
        rvereseArray(arr, d, n-1);
        rvereseArray(arr, 0, n-1);
    }

    /*Function to reverse arr[] from index start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int result[] = rotateArray(arr,2,5);
        for(int element:result){
            System.out.print(element + " ");
        }
    }
}
