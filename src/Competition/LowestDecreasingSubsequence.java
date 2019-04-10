package Competition;

public class LowestDecreasingSubsequence {

    public static int lds(int []input){
        int count = 1;
        int maxCount = 1;
        for(int i = 1; i < input.length; i++){
            count = 1;
            while(i < input.length && input[i - 1] >= input[i]){
                count++;
                i++;
            }
            if(count > maxCount){
               maxCount = count;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int []input = {1,3,2,4,3,2,2,2,2,5,4,3,2,1};
        System.out.println(lds(input));
    }
}
