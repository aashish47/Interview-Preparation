package Strings;

public class ValidNumber {
    public static int valid(String a){
        return (a.matches("\\s*[\\-\\+]?([0-9]*\\.?)?[0-9]+(e[\\-\\+]?[0-9]+)?\\s*")) ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(valid("    -1.234e+10   "));
    }
}
