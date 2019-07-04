package Arrays;

import java.util.ArrayList;

public class InfiniteGrid {
        public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

            int count = 0;
            int currA = A.get(0);
            int currB = B.get(0);
            for(int k = 1; k < A.size(); k++){
                count += Math.max(Math.abs(A.get(k) - currA) , Math.abs(B.get(k) - currB));
                currA = A.get(k);
                currB = B.get(k);
            }

            return count;
        }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(-6);
        A.add(-1);
        A.add(-4);
        A.add(-2);
        A.add(12);
        A.add(3);
        A.add(3);
        A.add(-2);
        A.add(13);
        A.add(-14);
        A.add(10);
        A.add(-2);
        A.add(0);
        A.add(-11);
        A.add(8);
        A.add(-9);
        A.add(-10);
        B.add(14);
        B.add(0);
        B.add(-11);
        B.add(-6);
        B.add(14);
        B.add(2);
        B.add(-10);
        B.add(0);
        B.add(-1);
        B.add(6);
        B.add(3);
        B.add(3);
        B.add(8);
        B.add(-10);
        B.add(7);
        B.add(-3);
        B.add(11);

        System.out.println(coverPoints(A,B));

    }

}
