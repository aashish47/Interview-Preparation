package Recursion;

public class ReverseString {

    public static String reverse(String input,int index){
        if(index < 0){
            return "";
        }
        return input.charAt(index) + reverse(input,index - 1) ;

    }
    public static void main(String[] args) {
        String input = "abc";
        String output = reverse(input,input.length() - 1);
        System.out.println(output);
    }
}
