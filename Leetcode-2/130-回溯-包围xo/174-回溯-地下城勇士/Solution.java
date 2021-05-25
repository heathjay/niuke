class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;

        int[][] dp = new int[n+1][m+1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[n][m-1] = dp[n-1][m] = 1;
        for(int i = n-1; i >= 0 ; i--){
            for(int j = m-1; j >= 0 ; j--){
                int minn = Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}


//因此，如果按照从左上往右下的顺序进行动态规划，我们无法直接确定到达(1,2)的方案，因为有两个重要程度相同的参数同时影响后续的决策。也就是说，这样的动态规划是不满足「无后效性」的。
//于是我们考虑从右下往左上进行动态规划。dp[i][j]表示从坐标(i,j) 到终点所需的最小初始值,如果此时我们的路径和不小于dp[i][j]我们就能到达终点。

//这样一来，我们就无需担心路径和的问题，只需要关注最小初始值,对于dp[i][j]我们只要关心 dp[i][j+1]和dp[i+1][j]最小值 minn,记当前格子的值为 du[i][j]