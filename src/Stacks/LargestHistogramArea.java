package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestHistogramArea {
    public static int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> pos = new Stack<>();
        Stack<Integer> height = new Stack<>();

        int max = Integer.MIN_VALUE;
        int area = 0;
        int index = -1;
        int ht = -1;
        int i = 0;
        for(; i < A.size(); i++){
            if(pos.isEmpty() || A.get(i) > height.peek()){
                pos.push(i);
                height.push(A.get(i));
            }

            else if(A.get(i) < height.peek()){
                while(!height.isEmpty() && height.peek() > A.get(i)){
                    ht = height.pop();
                    index = pos.pop();
                    area = ht * (i - index);
                    if(area > max){
                        max = area;
                    }
                }
                height.push(A.get(i));
                pos.push(index);
            }

        }
        while(!height.isEmpty()){
            ht = height.pop();
            index = pos.pop();
            area = ht * (i - index);
            if(area > max){
                max = area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        System.out.println(largestRectangleArea(arr));
    }
}
