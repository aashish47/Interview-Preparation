package Arrays;

public class QuickSort {

    public static void sort(int[] input,int beg,int end){
        if(beg>=end)
            return;
        int pivot = partion1(input,beg,end);
        sort(input,beg,pivot-1);
        sort(input,pivot+1,end);
    }

    public static int partion1(int[] arr,int low,int high){
        int pivot = arr[high];//pivot point
        int i = low - 1;

        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    public static void main(String[] args) {
        int []arr = {2,3,5,6,1,4};
        sort(arr,0,arr.length - 1);
        for (int num:arr) {
            System.out.println(num);
        }
    }
}
