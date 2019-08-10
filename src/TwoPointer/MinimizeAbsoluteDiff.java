package TwoPointer;
import java.util.ArrayList;

public class MinimizeAbsoluteDiff {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int diff = Integer.MAX_VALUE;
        int ia = 0, ib = 0, ic = 0;

        while(true){
            diff = Math.min(diff,
                    Math.max(Math.max(A.get(ia), B.get(ib)), C.get(ic)) -
                            Math.min(Math.min(A.get(ia), B.get(ib)), C.get(ic)));
            if(ia < A.size() - 1 && A.get(ia) <= B.get(ib) && A.get(ia) <= C.get(ic)){
                ia++;
            }
            else if(ib < B.size() - 1 && B.get(ib) <= A.get(ia) && B.get(ib) <= C.get(ic)){
                ib++;
            }
            else if(ic < C.size() - 1 && C.get(ic) <= B.get(ib) && C.get(ic) <= A.get(ia)){
                ic++;
            }
            else{
                break;
            }
        }

        return diff;
    }
}
