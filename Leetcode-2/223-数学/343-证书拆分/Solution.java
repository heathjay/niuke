class Solution {
    public int integerBreak(int n) {
        if(n < 2) return n;
        int[] dp = new int[n+1];
    
        for(int i =2 ;i < n+1;i++){
            
            for(int j = 1; j < i;j++){
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i-j) , (i-j) *j));
            }
        }
        return dp[n];
    }
}