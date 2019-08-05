package Strings;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrettyJson {
    public static String indentt(int tab){
        String ans = "";
        for(int i = 0; i < tab; i++){
            ans += "\t";
        }
        return ans;
    }
    public static ArrayList<String> pretty(String A){
        A = A.replaceAll("\\s","");
        ArrayList<String> ans = new ArrayList<>();
        int tab = 0;
        String temp = "";
        for(int i = 0; i < A.length(); i++){
            char curr = A.charAt(i);
            if(curr == '{' || curr == '['){
                if(temp.length() != 0){
                    temp = indentt(tab) + temp;
                    ans.add(temp);
                }
                temp = indentt(tab) + curr;
                ans.add(temp);
                tab++;
                temp = "";
            }
            else if(curr == '}' || curr == ']'){
                if(temp.length() != 0){
                    temp = indentt(tab) + temp;
                    ans.add(temp);
                }
                tab--;
                if(i < A.length() - 1 && A.charAt(i + 1) == ','){
                    temp = indentt(tab) + curr + ",";
                    i++;
                }
                else{
                    temp = indentt(tab) + curr;
                }
                ans.add(temp);
                temp = "";
            }
            else if(curr == ','){
                temp = indentt(tab) + temp + curr;
                ans.add(temp);
                temp = "";
            }
            else{
                temp += curr;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> ans = pretty("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]");
        for(String i: ans){
            System.out.println(i);
        }
    }
}
