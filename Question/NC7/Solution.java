import java.util.*;


public class Solution {
    /**
     * 
     * @param prices int整型一维数组 
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int len = prices.length;
        if(len==0) return 0;
        int[] min = new int[len];
        min[0] = prices[0];
        int val = 0;

        for(int i = 1; i < len; i++){
            if(min[i-1] < prices[i]){
                min[i] = min[i-1];
                val = Math.max(prices[i] - min[i], val);
            }else{
                min[i] = prices[i];
            }
        }
        return val;
    }
}