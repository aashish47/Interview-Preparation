package Competition;

import java.util.ArrayList;
import java.util.Scanner;

public class CodevitaPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = 10;
        String temp = "";
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i * 2; j++){
                temp += "*";
            }
            for(int j = 0; j < n - i; j++){
                temp += k;
                k += 10;
            }
            answer.add(temp);
            temp = "";
        }
        String temp1 = "";
        for(int i = 0; i < n ; i++){
            for(int j = 0; j <= i; j++){
                temp += k;
                k += 10;
            }
            temp1 = answer.get(n - 1 - i);
            temp1 = temp1 + temp;
            answer.set(n - 1 - i,temp1);
            temp = "";
        }
        for(int i = 0 ; i < n; i++){
            temp = answer.get(i);
            temp = temp.substring(0,temp.length() - 1);
            answer.set(i,temp);
        }

        for(String i: answer){
            System.out.println(i);
        }
    }
}
