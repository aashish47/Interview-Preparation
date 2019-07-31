package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RPN {
    public static int evalRPN(ArrayList<String> A) {
        Stack<String> stack = new Stack<>();
        String a = " ";
        String b = " ";
        String result = " ";
        String curr = " ";
        for(int i = 0; i < A.size(); i++){
            curr = A.get(i);
            if(curr == "+" || curr == "-" || curr == "*" || curr == "/"){
                b = stack.pop();
                a = stack.pop();
                if(curr == "+"){
                    int x = Integer.valueOf(a);
                    int y = Integer.valueOf(b);
                    int z = x + y;
                    result = "" + z;
                }
                if(curr == "-"){
                    result = (Integer.valueOf(a) - Integer.valueOf(b)) + "";
                }
                if(curr == "*"){
                    result = (Integer.valueOf(a) * Integer.valueOf(b)) + "";
                }
                if(curr == "/"){
                    result = (Integer.valueOf(a) / Integer.valueOf(b)) + "";
                }
                stack.push(result);
            }
            else{
                stack.push(curr);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("2", "2", "/"));
        System.out.println(evalRPN(arr));
    }
}
