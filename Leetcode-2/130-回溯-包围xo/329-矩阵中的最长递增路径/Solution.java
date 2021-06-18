class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int rows,  cols;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        rows = matrix.length;
        cols = matrix[0].length;

        int[][] memo = new int[rows][cols];
        int ans = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }

        return ans;
    }


    public int dfs(int[][] matrix, int row, int col, int[][] memo){
        if(memo[row][col] != 0){
            return memo[row][col];
        }
        memo[row][col]++;
        for(int[] dir: dirs){
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]){
                memo[row][col] = Math.max(memo[row][col], dfs(matrix, newRow,newCol,memo) + 1);
            }
        }
        return memo[row][col];
    }
}