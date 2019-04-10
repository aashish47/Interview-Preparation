package Competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Stairs {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int l = 0; l < t; l++){
            ArrayList<Integer> currentStairs = new ArrayList<>();
            int q = s.nextInt();
            int heights[] = new int[q];
            int steps[] = new int[q];
            for(int i =0; i < heights.length; i++){
                heights[i] = s.nextInt();
            }
            for(int i = 0; i < steps.length; i++){
                steps[i] = s.nextInt();
            }
            for(int i = 0; i < heights.length; i++){
                currentStairs.add((heights[i]));
                Collections.sort(currentStairs);
                int climb = steps[i];
                System.out.println(currentStairs.get(climb - 1) + " ");
            }
        }
    }


}
