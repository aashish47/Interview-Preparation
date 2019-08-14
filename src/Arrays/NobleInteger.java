package Arrays;
import java.util.*;
public class NobleInteger {
    public static int noble(ArrayList<Integer> a){
        Collections.sort(a);
        for(int i = a.size() - 1; i >=0; i--){
            int curr = a.get(i);
            if(curr == a.size() - 1 - i){
                return 1;
            }
            while(i >= 1 && a.get(i) == a.get(i - 1)){
                i--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,5,5,6));
        System.out.println(noble(a));
    }
}
