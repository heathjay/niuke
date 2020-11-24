import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 两次交易所能获得的最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int len = prices.length;
        if(len <= 1) return 0;
        int[] preMax = new int[len];
        preMax[0] = 0;
        int min = prices[0];

        for(int i = 1; i < len ; i++){
            min = Math.min(min, prices[i]);
            preMax[i] = Math.max(preMax[i-1], prices[i] - min);
        }


        int res = preMax[len-1];
        int postMax = 0;
        int value = 0;
        for(int i = len - 2; i >= 0;i--){
            postMax = Math.max(postMax, prices[i]);
            value = Math.max(value, postax - prices[i]);
            res = Math.max(res, preMax[i] + value);
        }
        return res;
    }
}