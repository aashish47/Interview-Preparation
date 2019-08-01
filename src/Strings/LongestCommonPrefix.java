package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LongestCommonPrefix {
    static class SortLength implements Comparator<String>{

        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }

    public static String longestCommonPrefix(ArrayList<String> A) {
        String result = "";
        Collections.sort(A, new SortLength());
        int len = A.get(0).length();
        int j = 0;
        for(int i = 0; i < len; i++){
            for(j = 0; j < A.size() - 1; j++){
                if(A.get(j).charAt(i) != A.get(j + 1).charAt(i)){
                    return result;
                }
            }
            result += A.get(j).charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("abc", "abbc", "a"));
        Collections.sort(arr, new SortLength());
        System.out.println(arr);
    }
}
