package Strings;
import java.lang.*;
public class Atoi {
    public static int num(char c){
        switch(c){
            case '0' : return 0;
            case '1' : return 1;
            case '2' : return 2;
            case '3' : return 3;
            case '4' : return 4;
            case '5' : return 5;
            case '6' : return 6;
            case '7' : return 7;
            case '8' : return 8;
            case '9' : return 9;
            default:return -1;
        }
    }
    public static int atoi(String s){
        String arr[] = s.split(" ");
        long ans = 0;
        long base = 1;
        int i = 0;
        int start = 0;
        int flag = 0;
        while(arr[i].equals("")){
            i++;
        }

        if(arr[i].charAt(0) == '-'){
            flag = 1;
            start = 1;
        }
        else if(arr[i].charAt(0) == '+'){
            start = 1;
        }
        else if(!Character.isDigit((arr[i].charAt(0)))){
            return 0;
        }
        int end = start;
        while(end < arr[i].length() && Character.isDigit(arr[i].charAt(end))){
            end++;
        }
        for(int j = end - 1; j >= start; j--){
            ans = num(arr[i].charAt(j)) * base + ans;
            base = base * 10;
            if(ans > Integer.MAX_VALUE){
                break;
            }
        }
        if(flag == 1){
            ans = -ans;
        }
        return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(atoi("-54332872018247709407"));
    }
}
