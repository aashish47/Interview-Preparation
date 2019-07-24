package Graph_IB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPathRectangle {
    static int[] x = {1, 1, -1, -1, 1, 0, -1, 0};
    static int[] y = {1, -1, -1, 1, 0, 1, 0, -1};

    public static String solve(int A, int B, int N, int R, ArrayList<Integer> E, ArrayList<Integer> F) {

        int valid[][] = new int[A + 1][B + 1];

        for(int i = 0; i <= A; i++){
            for(int j = 0; j <= B; j++){
                for(int k = 0; k < N; k++){
                    if(Math.sqrt(Math.pow(E.get(k) - i,2) + Math.pow(F.get(k) - j,2)) <= R){
                        valid[i][j] = -1;
                    }
                }
            }
        }

        if(valid[0][0] == -1 || valid[A][B] == -1){
            return "NO";
        }

        boolean visited[][] = new boolean[A + 1][B + 1];
        visited[0][0] = true;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.add(0);
        queueY.add(0);

        while(!queueX.isEmpty()){
            int x1 = queueX.poll();
            int y1 = queueY.poll();

            for(int i = 0; i < 8; i++){
                int xi = x1 + x[i];
                int yi = y1 + y[i];

                if(!(xi < 0) || !(xi > A) ||  !(yi < 0) || !(yi > B) && valid[xi][yi] != -1 && !visited[xi][yi]){
                    if(xi == A && yi == B){
                        return "YES";
                    }
                    queueX.add(xi);
                    queueY.add(yi);
                    visited[xi][yi] = true;
                }
            }
        }
        return "NO";

    }

    public static void main(String[] args) {
        int A = 2;
        int B = 3;
        int C = 1;
        int D = 1;
        ArrayList<Integer> E = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> F = new ArrayList<>(Arrays.asList(3));
        System.out.println(solve(A, B, C, D, E, F));
    }
}
