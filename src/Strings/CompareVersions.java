package Strings;

import java.math.BigInteger;

public class CompareVersions {
    public static boolean hasTrailZeros(String[] arr, int i){
        for(int k = i; k < arr.length; k++){
            String x = arr[k];
            for(int j = 0; j < x.length(); j++){
                if(x.charAt(j) != '0'){
                    return false;
                }
            }
        }
        return true;
    }
    public static int compare(String a, String b){
        String[] arrA = a.split("\\.");
        String[] arrB = b.split("\\.");
        int i;
        int len = Math.min(arrA.length, arrB.length);
        for(i = 0; i < len; i++){
            String a1 = arrA[i];
            String b1 = arrB[i];
            BigInteger A = new BigInteger(a1);
            BigInteger B = new BigInteger(b1);
            if(A.compareTo(B) == 1){
                return 1;
            }
            if(A.compareTo(B) == -1){
                return -1;
            }

        }
        if(i != arrA.length && !hasTrailZeros(arrA, i)){
            return 1;
        }
        else if(i != arrB.length && !hasTrailZeros(arrB, i)){
            return -1;
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(compare("13.0", "13.0.0.0"));
    }
}
