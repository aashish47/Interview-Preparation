package Math;

public class SieveOfEratosthenes {

    public static void primeUptoN(int n){
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;
        for(int i = 2; i <= n; i++){
            arr[i] = 1;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(arr[i] == 1){
                for(int j = 2; i * j <= n; j++){
                    arr[i * j] = 0;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0)
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int n = 100;
        primeUptoN(n);
    }
}
