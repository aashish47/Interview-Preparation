package Competition;

import java.util.Scanner;

public class BusStops {

    public static int[] busStops(int n, int[] arr){

        int result[] = new int[n];
        result[0] = arr[0];
        for(int i = n - 1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                if((i + 1) % (j + 1) == 0){
                    result[i] = arr[i];
                    result[i] -= arr[j];
                }
            }
        }
        return result;
    }

    public static int[] busStops1(int n, int[] arr){
        int result[] = new int[n];
        result[0] = arr[0];

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if((j + 1) % (i + 1) == 0){
                    result[j] = arr[j] - arr[i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }
//        int result[] = busStops(n, arr);
        int result1[] = busStops1(n, arr);

        for(int i : result1){
            System.out.println(i);
        }

    }
}
