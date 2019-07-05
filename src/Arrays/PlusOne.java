package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlusOne {
    public static ArrayList<Integer> removeZeros(ArrayList<Integer> A){
        int ctrZero = 0;
        int zeros = 0;
        int i = 0;

        while(i < A.size() && A.get(i) == 0){
            i++;
        }
        zeros = i;

        if(i == 0){
            return A;
        }
        for(;i < A.size(); i++){
            A.set(ctrZero++,A.get(i));
        }

        for(int j = zeros; j > 0; j--){
            A.remove(A.size() - 1);
        }
        return A;

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        return removeZeros(A);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(3);
        plusOne(A);
        for(int i : A){
            System.out.println(i);
        }
    }
}
