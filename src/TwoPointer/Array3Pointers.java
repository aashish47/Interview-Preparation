package TwoPointer;

import java.util.ArrayList;

public class Array3Pointers {

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int diff = Integer.MAX_VALUE;
        int ia = 0, ib = 0, ic = 0;

        while(true){
            int a = A.get(ia);
            int b = B.get(ib);
            int c = C.get(ic);
            diff = Math.min(diff, Math.max(Math.max(Math.abs(a - b),Math.abs(b - c)), Math.abs(c - a)));
            if(ia < A.size() - 1 && a <= b && a <= c){
                ia++;
            }
            else if(ib < B.size() - 1 && b <= a && b <= c){
                ib++;
            }
            else if(ic < C.size() - 1 && c <= b && c <= a){
                ic++;
            }
            else{
                break;
            }
        }

        return diff;
    }
}
