package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidSudoku {
    public static int isValidSudoku(final List<String> A) {
        HashMap<Character, Integer> map = new HashMap<>();
        char curr;
        String str;
        if(A.size() != 9){
            return 0;
        }
        for(int i = 0; i < A.size(); i++){
            str = A.get(i);
            if(str.length() != 9){
                return 0;
            }
            for(int j = 0; j < str.length(); j++){
                curr = str.charAt(j);
                if(curr == '.'){
                    continue;
                }
                if(map.containsKey(curr)){
                    return 0;
                }
                else{
                    map.put(curr,1);
                }
            }
            map.clear();
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                str = A.get(j);
                curr = str.charAt(i);
                if(curr == '.'){
                    continue;
                }
                if(map.containsKey(curr)){
                    return 0;
                }
                else{
                    map.put(curr,1);
                }
            }
            map.clear();
        }
        int m = 0;
        int n = 3;
        int o = 0;
        int p = 3;
        for(int i = 0; i < 3; i++) {
            m = 0;
            n = 3;
            for (int a = 0; a < 3; a++) {
                for (int j = o; j < p; j++) {
                    for (int k = m; k < n; k++) {
                        str = A.get(j);
                        curr = str.charAt(k);
                        if (curr == '.') {
                            continue;
                        }
                        if (map.containsKey(curr)) {
                            return 0;
                        } else {
                            map.put(curr, 1);
                        }
                    }
                }
                m = n;
                n = n + 3;
                map.clear();
            }
            o = p;
            p = p + 3;
        }
        return 1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."));
        System.out.println(isValidSudoku(list));
    }
}
