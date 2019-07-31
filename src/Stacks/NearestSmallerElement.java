package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {
    public static ArrayList<Integer> nearestSmallerElement(ArrayList<Integer> arr){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++){
            while(!stack.isEmpty() &&  arr.get(i) <= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(-1);
            }
            else{
                ans.add(stack.peek());
            }
            stack.add(arr.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(4,5,2,10,8));
        System.out.println(nearestSmallerElement(ans));
    }
}
