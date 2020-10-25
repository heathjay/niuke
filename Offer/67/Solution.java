/*
贪心算法
    Math(n, i -c) * Math(n+1, c)'
    '
*/
public class Solution {
    public int cutRope(int target) {
 
        int result = 0;
        for (int i = 2; i <= target; i++) {
            int n = target / i, c = target % i;
            int ans = (int) (Math.pow(n, i - c) * Math.pow(n + 1, c));
            if (ans > result) {
                result = ans;
            }
        }
        return result;
    }
}

/**
 * 动态规划
 */

public class Solution {
    public int cutRope(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= target;i++){
            if(i!=target){
                dp[i] = i;
            }
            for(int j = 1; j < i;j++){
                dp[i] = Math.max(dp[i], dp[j] * dp[i-j]);
            }
        }
        return dp[target];
    }
}