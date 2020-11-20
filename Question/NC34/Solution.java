import java.util.*;


public class Solution {
    /**
     * 
     * @param m int整型 
     * @param n int整型 
     * @return int整型
     */

    public int uniquePaths (int m, int n) {
        // write code here
        if(m==0) return 0;
        if(n==0) return 0;
        if(m == n && m == 1)return 1;

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            dp[i][1] = 1;
        }

        for(int i = 1; i <= n; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= m; i++){
            for(int j = 2; j <= n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];

    } 
}