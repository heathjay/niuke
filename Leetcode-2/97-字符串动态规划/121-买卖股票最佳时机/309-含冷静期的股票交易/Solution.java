class Solution{
    public int maxProfit(int[] prices){
        if(prices.length == 0){
            return 0;
        }

        int n = prices.length;
        int[][] f = new int[n][3];
        //f[i][0]  持有
        //f[i][1] 冷却
        //f[i][2] 卖出
        f[0][0] = -prices[0];
        for(int i = 1 ; i < n ; i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][2] - prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][1], f[i-1][2]);
        }
        return Math.max(f[n-1][1], f[n-1][2]);
    }
}