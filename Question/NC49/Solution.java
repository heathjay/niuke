import java.util.*;


public class Solution {
    /**
     * 
     * @param s string字符串 
     * @return int整型
     */
    public int longestValidParentheses (String s) {
        // write code here
        int len = s.length();
        int[] dp = new int[len];
        int maxval = 0;
        for(int i = 1; i < len; i ++){
            char c = s.charAt(i);
            if(c == ')'){
                int pre = i - 1 - dp[i-1];
                if(pre >= 0 && s.charAt(pre) == '('){
                    dp[i] = dp[i-1] + 2;
                    if(pre - 1 >= 0){
                        dp[i] += dp[pre-1];
                    }
                }
            }
            maxval = Math.max(maxval, dp[i]);
        }
        return maxval;
    }
}