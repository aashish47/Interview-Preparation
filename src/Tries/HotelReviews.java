package Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HotelReviews {
    public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        String[] words = A.split("_");
        HashMap<String,Integer> words2 = new HashMap<>();
        for(int j = 0 ; j < words.length; j++){
            if(words2.containsKey(words[j])){
                words2.put(words[j], words2.get(words[j]) + 1);
            }
            else{
                words2.put(words[j],1);
            }
        }
        HashMap<String,Integer> review;
        int count = 0;
        ArrayList<Integer> ansCount = new ArrayList<>();
        for(int i = 0; i < B.size(); i++){
            String rev[] = B.get(i).split("_");
            count = 0;
            review = new HashMap<>();
            for(int j = 0; j < rev.length; j++){
                if(review.containsKey(rev[j])){
                    review.put(rev[j], review.get(rev[j]) + 1);
                }
                else{
                    review.put(rev[j],1);
                }

            }
            for(Map.Entry<String,Integer> entry: words2.entrySet()){
                if(review.containsKey(entry.getKey())){
                    count += review.get(entry.getKey());
                }
            }

            ansCount.add(count);

        }

        ArrayList<Integer> ans2 = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int maxI = -1;
        count = ansCount.size();
        while(count > 0){
            for(int i = 0; i < ansCount.size(); i++){
                if(ansCount.get(i) > max){
                    max = ansCount.get(i);
                    maxI = i;

                }
            }
            ans2.add(maxI);
            max = -1;
            ansCount.set(maxI,-2);
            count--;
        }
        return ans2;
    }
    public static void main(String[] args) {
        String a = "cool_ice_wifi";
        ArrayList<String> b = new ArrayList<>();
        b.add("water_is_cool");
        b.add("cold_ice_drink");
        b.add("cool_wifi_speed");
        b.add("cool_wifi_speed");
        System.out.println(solve(a,b));
    }
}
