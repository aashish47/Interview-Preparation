package Competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GoodRanges {

    public static int rangeSum(List<Integer> m1,int left,int right){
        Collections.sort(m1);
        if(m1.size() == 1){
           return left + right;
        }
        int sum = 0;
        int l,r;
        for(int i = 0; i < m1.size(); i++){
           if(i == 0){
               l = 1;
               r = m1.get(i + 1) - 1;
           }
           else if(i == m1.size() - 1){
               l = m1.get(i - 1) + 1;
               r = right;
           }
           else{
               l = m1.get(i - 1) + 1;
               r = m1.get(i + 1) - 1;
           }
           sum += l + r;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int left = 1;
        int right = n;
        List<Integer> m1 = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < m; i++){
            m1.add(s.nextInt());
        }
        for(int i = 0; i < m; i++){
            sum = rangeSum(m1.subList(0,i + 1),left,right);
            System.out.println(sum);
        }
    }
}
