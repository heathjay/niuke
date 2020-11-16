import java.util.*;


public class Solution {
    /**
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            dp[i][0] = i*dc;
        }

        for(int i = 1; i <= n; i++){
            dp[0][i] = i * ic;
        }


        for(int i = 1; i < m + 1; i++){
            char c1 = str1.charAt(i-1);
            for(int j = 1; j < n + 1; j++){
                char c2 = str2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = dp[i][j-1] + ic;
                    int delete = dp[i-1][j] + dc;
                    int replace = dp[i-1][j-1] + rc;
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[m][n];
    }
}