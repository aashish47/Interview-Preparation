package Competition;

import java.util.Scanner;

public class PaintFence {

    public static int strokes(int[] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            count += arr[i];
        }
        int stroke = 0;
        while(count != 0){
            for(int i = 0; i < arr.length; i++){

                while(i < arr.length &&arr[i] != 0){
                    arr[i] = arr[i] - 1;
                    count--;
                    i++;
                }
                stroke++;
            }
        }
        return stroke;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = s.nextInt();
        }

        System.out.println(strokes(arr));
    }
}
