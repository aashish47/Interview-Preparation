package Math;

public class IsPalindrome {
    public static int isPalindrome(int A) {
        if(A < 0){
            return 0;
        }
        if(A < 10){
            return 1;
        }
        int B = A;
        int result = 0;
        while(B>0){
            result = result * 10 + B%10;
            B /= 10;
        }
        if(result != A){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
