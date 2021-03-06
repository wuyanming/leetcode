package HighFrequence.Summary;

public class BestTimetoBuyandSellStock121 {

    //Approach 2: One Pass
    //Time complexity : O(n)O(n). Only a single pass is needed.
    //
    //Space complexity : O(1)O(1). Only two variables are used.

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }

        return maxprofit;
    }

}
