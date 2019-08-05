package TwoPointer;

import java.util.ArrayList;

public class MergeTwo {
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b){
        int i = 0;
        int j = 0;
        ArrayList<Integer> c = new ArrayList<>();
        for(; i < a.size() && j < b.size(); ){
            int currA = a.get(i);
            int currB = b.get(j);
            if(currA < currB){
                i++;
                c.add(currA);
            }
            else if(currB < currA){
                j++;
                c.add(currB);
            }
            else{
                i++;
                j++;
                c.add(currA);
                c.add(currB);
            }
        }
        if(i == a.size()){
            while(j != b.size()){
                c.add(b.get(j++));
            }
        }
        if(j == b.size()){
            while(i != a.size()){
                c.add(a.get(i++));
            }
        }
        a.clear();
        a.addAll(c);
    }

    public static void main(String[] args) {
    }
}
