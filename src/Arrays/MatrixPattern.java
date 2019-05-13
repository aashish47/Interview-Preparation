package Arrays;


public class MatrixPattern {

    public static void main(String[] args) {
        printPattern(5);
    }

    /* Input
     * n - number of rows */
    public static void printPattern(int n) {

        // Write your code here
        int arr[][] = new int[n][n];
        int count = 1;
        int flag = 0;
        int i = 0;
        int topFill = 0;
        int bottomFill = n - 1;

        while (count <= n * n) {
            if (flag == 0) {
                for (int j = 0; j < n; j++) {
                    arr[topFill][j] = count++;
                }
                flag = 1;
                topFill++;
            }
            else {
                for (int j = 0; j < n; j++) {
                    arr[bottomFill][j] = count++;
                }
                flag = 0;
                bottomFill--;
            }
        }

        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}