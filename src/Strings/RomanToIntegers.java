package Strings;

public class RomanToIntegers {
    public static int romanToInt(String roman){
        if(roman.length() == 0){
            return 0;
        }
        int ans = 0;
        int count = 0;
        for(int i = roman.length() - 1; i >= 0; i--){
            char curr = roman.charAt(i);
            if(curr == 'X'){
                if(i > 0 && roman.charAt(i - 1) == 'I'){
                    count += 9;
                    i--;
                }
                else{
                    count += 10;
                }
                ans = ans + count;
                count = 0;
            }
            else if(curr == 'V'){
                if(i > 0 && roman.charAt(i - 1) == 'I'){
                    count += 4;
                    i--;
                }
                else {
                    count += 5;
                }
                ans = ans + count;
                count = 0;
            }
            else if(curr == 'C'){
                if(i > 0 && roman.charAt(i - 1) == 'X'){
                    count += 90;
                    i--;
                }
                else{
                    count += 100;
                }
                ans = ans + count;
                count = 0;
            }
            else if(curr == 'L'){
                if(i > 0 && roman.charAt(i - 1) == 'X'){
                    count += 40;
                    i--;
                }
                else {
                    count += 50;
                }
                ans = ans + count;
                count = 0;
            }
            else if(curr == 'M'){
                if(i > 0 && roman.charAt(i - 1) == 'C'){
                    count += 900;
                    i--;
                }
                else{
                    count += 1000;
                }
                ans = ans + count;
                count = 0;
            }
            else if(curr == 'D'){
                if(i > 0 && roman.charAt(i - 1) == 'C'){
                    count += 400;
                    i--;
                }
                else {
                    count += 500;
                }
                ans = ans + count;
                count = 0;
            }
            else{
                count++;
            }
        }
        return ans == 0 ? count : ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MXCIII"));
    }
}
