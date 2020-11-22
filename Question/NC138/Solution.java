import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, cols;

    public int solve (int[][] matrix) {
        // write code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

         rows = matrix.length;
         cols = matrix[0].length;

        int[][] memo = new int[rows][cols];

        int res = 0;
        for(int i = 0 ; i< rows; i++){
            for(int j = 0 ; j < cols; j++){
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int row, int col, int[][] memo){
        if(memo[row][col] != 0){
            return memo[row][col];
        }

        memo[row][col] = 1;
        for(int[] dir : dirs){
            int newRow = row + dir[0] , newCol = col + dir[1];
            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]){
                memo[row][col] = Math.max(memo[row][col], dfs(matrix, newRow, newCol,memo) + 1);
            }
        }
        return memo[row][col];
    }
}