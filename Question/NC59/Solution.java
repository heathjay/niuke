import java.util.*;


public class Solution {
    /**
     * 
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        // write code here
        //动态规划
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < col; i++){
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }

        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        for(int i = 1; i < row ; i ++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + matrix[i-1][j-1];
            }
        }
        return dp[row-1][col-1];
    }
}