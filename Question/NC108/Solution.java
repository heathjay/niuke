import java.util.*;


public class Solution {
    /**
     * 最大正方形
     * @param matrix char字符型二维数组 
     * @return int整型
     */
    public int solve (char[][] matrix) {
        // write code here

        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int max = 0;
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == '1') dp[i][0] = 1;
        }

        for(int i = 0 ; i < cols;i++){
            if(matrix[0][i] == '1') dp[0][i] = 1;
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols ; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1]) + 1;
                    if(dp[i][j] > max) max = dp[i][j];
                }
            }
        }
        return max * max;
    }
}