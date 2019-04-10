package Competition;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static boolean partition(HashMap<Character,Integer> mapLeft,HashMap<Character,Integer> mapRight,int k){
        int count = 0;

        for(Map.Entry<Character,Integer> entry : mapLeft.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if(mapRight.containsKey(key)){
                if(mapRight.get(key) == value){
                    count++;
                    if(count >=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static HashMap<Character,Integer> map(String s){
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map1.containsKey(c)){
                map1.put(c,map1.get(c) + 1);
            }
            else{
                map1.put(c,1);
            }
        }
        return map1;
    }
    public static int count(String s, int k){
        int count = 0;
        HashMap<Character,Integer> mapLeft = new HashMap<>();
        HashMap<Character,Integer> mapRight = new HashMap<>();
        for(int i =0; i < s.length() - 1; i++){
            mapLeft = map(s.substring(0,i+1));
            mapRight = map(s.substring(i+1,s.length()));

            if(partition(mapLeft,mapRight,k)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        String s1 = s.next();
        System.out.println(count(s1,k));
    }
}
