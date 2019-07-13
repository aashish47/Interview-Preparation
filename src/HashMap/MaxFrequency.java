package HashMap;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {
    public static int maxFrequencyNumber(int[] arr){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]) + 1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        int ans = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(map.get(arr[i]) > max){
                max = map.get(arr[i]);
                ans = arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2, 12, 2, 11, 12, 2, 1, 2, 2, 11, 12, 2, 6};
        maxFrequencyNumber(arr);
    }
}
