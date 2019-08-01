package HashMap;

import java.util.HashMap;

public class ColourfulNumbers {
    public static int colorful(int A) {
        String num = Integer.toString(A);
        int len = num.length();
        int res = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - i; j++){
                for(int k = 0; k <= i; k++){
                    res *= Integer.valueOf(""+num.charAt(j + k));
                }
                if(map.containsKey(res)){
                    return 0;
                }
                map.put(res, 1);
                res = 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(colorful(123));
    }
}

