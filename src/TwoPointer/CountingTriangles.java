package TwoPointer;
import java.util.*;
public class CountingTriangles {
    public static int countTriangles(ArrayList<Integer> a) {

        {
            int c = 0;
            Collections.sort(a); //sprt the array
            int mod = 1000000007;
            for (int i = 0; i < a.size() - 2; i++)//fix one side and then find others or you can say how many triangles are possible with ith side
            {
                int k = i + 2;
                for (int j = i + 1; j < a.size(); ++j)//now fix second side
                {
                    while (k < a.size() && a.get(i) + a.get(j) > a.get(k))//find the rightmost point which satisfies the triangle formation condtiion
                        ++k;
                    if (k > j)
                        c = (c % mod + (k - j - 1) % mod) % mod;
                }
            }
            return c;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,1,1,2,2));
        System.out.println(countTriangles(A));
    }
}
