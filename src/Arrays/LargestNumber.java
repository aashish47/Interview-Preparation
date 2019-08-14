package Arrays;
import java.util.*;
public class LargestNumber {

        public static String largest(ArrayList<Integer> num) {
            Collections.sort(num, new sortNum());
            StringBuilder ans = new StringBuilder();
            for (int i = num.size() - 1; i >= 0; i--) {
                ans.append(num.get(i) + "");
            }
            int i = 0;
            for (; i < ans.length() && ans.charAt(i) == '0'; i++) ;
            if (i == ans.length()) {
                return "0";
            }
            String ans1 = ans.substring(i);
            return ans1;
        }

        public static void main(String[] args) {
            ArrayList<Integer> num = new ArrayList<>(Arrays.asList(12, 121));
            System.out.println(largest(num));
        }

    public static class sortNum implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            String a = String.valueOf(o1);
            String b = String.valueOf(o2);
            return (a + b).compareTo(b + a);
        }
    }
}
