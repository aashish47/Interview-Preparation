package Math;

public class ExcelColumn {
    public static int titleToNumber(String A) {
        int result = 0;
        for(int i = 0; i < A.length(); i++){
            result = result * 26  + (A.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("BZ"));
    }
}
