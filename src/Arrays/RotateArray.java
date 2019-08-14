package Arrays;
import java.util.*;
public class RotateArray {
    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size() - 1;
        for(int i = 0; i < n + 1 / 2 ; i++){
            for(int j = i; j < n - i; j++){
                int t = a.get(i).get(j);
                a.get(i).set(j, a.get(n - j).get(i));
                a.get(n - j).set(i, a.get(n - i).get(n - j));
                a.get(n - i).set(n - j, a.get(j).get(n - i));
                a.get(j).set(n - i, t);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1,2,3)));
        arr.add(new ArrayList<>(Arrays.asList(4,5,6)));
        arr.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println("BEFORE ROTATE");
        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < arr.size(); j++){
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println("AFTER ROTATE");
        rotate(arr);
        for(int i = 0; i < arr.size(); i++){
            for(int j = 0; j < arr.size(); j++){
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
