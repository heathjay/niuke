import java.util.*;


public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        int m = str1.length();
        int n = str2.length();
        if(m == 0 || n == 0) return "-1";
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int start1 = -1;
        int start2 = -1;

        int[][] dp = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++){
            dp[i][0] = (s1[i] == s2[0] ? 1 : 0);
            for(int j = 0; j< n; j++){

                dp[0][j] = (s1[0] == s2[j] ? 1 :0);
                if(i > 0 && j > 0){
                    if(s1[i] == s2[j]){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                if(max < dp[i][j]){
                    max = dp[i][j];
                    start1 = i+1 - max;
                    start2 = j+1 -max;
                }
            }
        }
        if(max == 0) return "-1";
        return str1.substring(start1, max+start1);
    }
}