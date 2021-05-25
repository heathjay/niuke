class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len ==0) return 0;
        int minVal = prices[0];
        int profit = 0;
        for(int i = 1; i < len; i++){
            if(prices[i] < minVal){
                minVal = prices[i];
            }else if(prices[i] - minVal > profit){
                profit = prices[i] - minVal;
            }
        }
        return profit;
    }
}