package HashMap;

import java.util.HashMap;

public class PairSum {
    public static void PairSum1(int[] input, int size) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print the desired output and don't return anything.
         * Taking input is handled automatically.
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        int freq = 0;
        for(int i = 0; i < size; i++){
            if(map.containsKey(input[i])){
                map.put(input[i],map.get(input[i]) + 1);
            }
            else{
                map.put(input[i],1);
            }
            if(map.containsKey(-input[i])){
                for(int j = 0; j < map.get(-input[i]); j++){
                    System.out.print(Math.min(-input[i],input[i]) + " ");
                    System.out.print(Math.max(-input[i],input[i]));
                    System.out.println();
                }

            }

        }

    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, 2, -2, 6};
        PairSum1(arr,5);
    }
}
