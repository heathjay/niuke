import java.util.*;


public class Solution {
    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        // write code here

        String[] StringDp = new String[s1.length()+1];
        for(int i = 0; i < StringDp.length; i++){
            StringDp[i] = new String();
        }

        int[] dp = new int[s2.length() + 1];
        for(int i = 1; i <= s1.length(); i++ ){
            int prev = dp[0], curr = dp[1];
            String StringPrev = StringDp[0], StringCur = StringDp[1];
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[j] = prev+1;
                    StringDp[j] = StringPrev + s2.substring(j-1,j);
                }else{
                    dp[j] = Math.max(curr, dp[j-1]);
                    if(curr > dp[j-1]){
                        dp[j] = curr;
                        StringDp[j] = StringCur;
                    }else{
                        dp[j] = dp[j-1];
                        StringDp[j] = StringDp[j-1];
                    }
                }

                if(j < s2.length()){
                    prev = curr;
                    curr = dp[j+1];
                    StringPrev = StringCur;
                    StringCur = StringDp[j+1];
                }
            }
        }
        return StringDp[s2.length()];
    }
}