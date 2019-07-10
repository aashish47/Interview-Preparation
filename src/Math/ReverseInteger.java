package Math;

public class ReverseInteger {
    public static  int reverse(int A) {
        long result = 0;
        boolean flag = A < 0;
        A = Math.abs(A);
        while(A>0){
            result = result * 10 + A%10;
            A /= 10;
        }
        if(result > Integer.MAX_VALUE){
            return 0;
        }
        return flag ? -(int)result: (int)result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1146467285));
    }
}
