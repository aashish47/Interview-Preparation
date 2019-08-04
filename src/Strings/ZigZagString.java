package Strings;

import java.util.ArrayList;

public class ZigZagString {
    public static String convert(String A, int B) {

        if(B == 1){
            return A;
        }

        int k = 0;
        ArrayList<String> result = new ArrayList<>();


        for(; k < B && k < A.length(); k++){
            result.add(A.charAt(k) + "");
        }
        k -= 2;
        for(int i = B; i < A.length();){
            for(; k >= 0 && i < A.length(); k--){
                result.set(k,result.get(k) + A.charAt(i++));
            }
            k += 2;
            for(; k < B && i < A.length(); k++){
                result.set(k, result.get(k) + A.charAt(i++));
            }
            k -= 2;
        }
        String ans = "";
        for(String s : result){
            ans += s;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
