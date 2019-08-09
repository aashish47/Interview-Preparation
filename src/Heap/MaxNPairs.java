package Heap;

import Trees.CountLeafNodes;

import java.lang.reflect.Array;
import java.util.*;

public class MaxNPairs {

    public static class sumCompare implements Comparator<MyClass> {
        public int compare(MyClass o1, MyClass o2) {
            return o2.sum - o1.sum;
        }
    }

    public static class MyClass{
        int i;
        int j;
        int sum;
        MyClass(int sum, int i, int j){
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        public boolean equals(Object o) {
            MyClass obj = (MyClass)o;
            if(obj.sum == this.sum  && obj.i == this.i && obj.j==this.j){
                return true;
            }
            return false;
        }

        public int hashCode()
        {
            return Objects.hash(sum,i,j);
        }
    }

    public static ArrayList<Integer> maxN(ArrayList<Integer> A, ArrayList<Integer> B){
        Collections.sort(A);
        Collections.sort(B);
        int n = A.size();
        HashSet<MyClass> set = new HashSet<>();
        PriorityQueue<MyClass> queue = new PriorityQueue<>(new sumCompare());
        MyClass node = new MyClass(A.get(n - 1) +  B.get(n - 1), n - 1, n - 1);
        queue.add(node);
        set.add(node);
        ArrayList<Integer> ans = new ArrayList<>();
        while(n --> 0){
            node = queue.poll();
            ans.add(node.sum);
            int i = node.i;
            int j = node.j;

            if(i == 0 || j == 0){
                continue;
            }

            node = new MyClass(A.get(i) + B.get(j - 1), i, j - 1);
            if(!set.contains(node)){
                set.add(node);
                queue.add(node);
            }
            node = new MyClass(A.get(i - 1) + B.get(j), i - 1, j);
            if(!set.contains(node)){
                set.add(node);
                queue.add(node);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43));
        System.out.println(maxN(A, B));
    }
}
