class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) return 0;

        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m && obstacleGrid[i][0] != 1; i++){
            
                dp[i][0] = 1;

        }

        for(int j = 0; j < n && obstacleGrid[0][j] == 0; j++){
     
                dp[0][j] = 1;

        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];

    }
    public int uniquePathsWithObstacles1(int[][] obstacleGrid){
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i =0 ; i < n ; i ++){
            for(int j = 0; j < m; j++){
                if(obstacleGrid[i][j] == 1){
                    f[j] = 0;
                    continue;
                }
                if(j - 1>=0 && obstacleGrid[i][j-1] == 0){
                    f[j] += f[j-1];
                }
            }
        }
        return f[m-1];

    }
}