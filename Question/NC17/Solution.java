import java.util.*;

public class Palindrome {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        char[] aa = A.toCharArray();
        int max = 1;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = true;
        }

        for(int i =1 ; i < n ; i++){
            //i指向最后一个字符
            for(int j = i-1; j >= 0; j--){
                if(i-j == 1){
                    dp[j][i] = (aa[i] == aa[j]);
                    if(max < i - j + 1){
                        max = i-j+1;
                    }
                }else{
                    if(dp[j+1][i-1] && aa[i]==aa[j]){
                        dp[j][i] = true;
                        if(max<i-j+1){
                            max = i-j+1;
                        }
                    }else{
                        dp[j][i] = false;
                    }
                }
            }
        }
        return max;
    }
}