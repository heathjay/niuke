import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here

        int len = prices.length;
        if(len == 0 || prices == null) return null;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < n ; i ++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[len-1][0];
    }


    public int maxProfit_k(int k, int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //当k非常大时转为无限次交易
        if(k>=n/2) {
            int dp0=0,dp1=-prices[0];
            for(int i=1;i<n;++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }
        //定义二维数组，交易了多少次、当前的买卖状态  
        int[][] dp = new int[k+1][2];
        int res = 0;
        for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0]; 
        }
        for(int i=1;i<n;++i) {
            for(int j=k;j>0;--j) {
                //处理第k次买入
                dp[j-1][1] = Math.max(dp[j-1][1], dp[j-1][0]-prices[i]);
                //处理第k次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]+prices[i]);

            }
        }
        return dp[k][0];
    }
}