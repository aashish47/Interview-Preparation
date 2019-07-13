package Math;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationRank {
    public static ArrayList<String> perm(String A){
        if(A.length() == 1){
            ArrayList<String> smallAns = new ArrayList<>();
            smallAns.add(A);
            return smallAns;
        }
        ArrayList<String> smallAns = new ArrayList<>();
        smallAns = perm(A.substring(0,A.length() - 1));
        String ch = "" + A.charAt(A.length() - 1);
        ArrayList<String> newAns = new ArrayList<>();
        for(int i = 0; i < smallAns.size(); i++){
            String str = smallAns.get(i);
            String temp = "";
            for(int j = 0; j <= str.length(); j++){
                temp = str.substring(0,j) + ch;
                if(j < str.length()){
                    temp += str.substring(j);
                }
                newAns.add(temp);
            }
        }
        return newAns;
    }
    public static int findRank(String A) {
        ArrayList<String> ans = new ArrayList<>();
        ans = perm(A);
        Collections.sort(ans);
        int index = 0;
        for(int i = 0 ; i < ans.size(); i++){
            if(ans.get(i).equals(A)){
                index =  i + 1;
                break;
            }
        }
        return index;
    }
    static long fact(int n)
    {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }

    static int findSmallerInRight(String str, int low,int high)
    {
        int countRight = 0, i;
        for (i = low + 1; i <= high; ++i)
            if (str.charAt(i) < str.charAt(low))
                ++countRight;
        return countRight;
    }
    public static int findRank1(String str) {
        int len = str.length();
        long mul = fact(len );
        int rank = 1;
        int countRight;

        for (int i = 0; i < len; ++i) {
            mul /= len - i;
            countRight = findSmallerInRight(str, i, len - 1);
            rank += countRight * mul;
        }

        return rank % 1000003;
    }

    public static void main(String[] args) {
        System.out.println(findRank1("DTNGJPURFHYEW"));
    }
}
