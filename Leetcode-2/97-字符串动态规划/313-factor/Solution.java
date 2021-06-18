class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] points = new int[primes.length];
        Arrays.fill(points,0);
        for(int i = 1; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length;  j++){
                dp[i] = Math.min(primes[j] * dp[points[j]], dp[i]);
               
            }
            for(int j = 0 ;  j < primes.length; j++){
                if(dp[i] == primes[j] * dp[points[j]]){
                    points[j]++;
                }
            }
        }
        return dp[n-1];
    }
}