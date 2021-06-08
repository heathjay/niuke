class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int cols = matrix[0].length;
        if(cols == 0) return 0;
        int[][] dp = new int[rows][cols];
        
        int side = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    }else{
 dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;
                    }
                   
                    side = Math.max(dp[i][j], side);
                }
            }
        }
        return side*side;
    }
   
}