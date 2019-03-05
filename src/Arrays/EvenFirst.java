package Arrays;

public class EvenFirst {

    public static void evenOdd(int[] arr){
        int nextEven = 0;
        int nextOdd = arr.length - 1;
        int temp = 0;
        while (nextEven < nextOdd){
            if(arr[nextEven] % 2 == 0){
                nextEven++;
            }
            else{
                temp = arr[nextEven];
                arr[nextEven] = arr[nextOdd];
                arr[nextOdd--] = temp;
            }
        }

    }
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,4,5,6};
        evenOdd(arr);
        for(int element: arr){
            System.out.print(element);
        }
    }
}
