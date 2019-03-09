package Arrays;

import java.util.ArrayList;

public class StockSellOnce {

    public static int maxProfit(ArrayList<Integer> arr){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < arr.size(); i++){
            maxProfit = Math.max(maxProfit,arr.get(i) - minPrice);
            minPrice = Math.min(minPrice,arr.get(i));
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(310);
        arr.add(315);
        arr.add(275);
        arr.add(295);
        arr.add(260);
        arr.add(270);
        arr.add(290);
        arr.add(230);
        arr.add(255);
        arr.add(250);
        System.out.println(maxProfit(arr));
    }
}
