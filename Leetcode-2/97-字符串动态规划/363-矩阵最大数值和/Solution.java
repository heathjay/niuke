class Solution {
    public int maxSumSubmatrix1(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                int[][] dp = new int[rows+1][cols+1];
                dp[i][j] = matrix[i-1][j-1];
                for(int row = i; row <= rows; row++){
                    for(int col = j; col <= cols; col++){
                        dp[row][col] = dp[row-1][col]+ dp[row][col-1]-dp[row-1][col-1] + matrix[row-1][col-1];
                        if(dp[row][col] <=k && dp[row][col] > max){
                            max = dp[row][col];
                        }
                    }
                }

            }
        }
        return max;
    }


    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int l = 0; l < cols; l++){
            int[] rowSum = new int[rows];
            for(int r = l; r < cols; r++){
                for(int i = 0; i < rows; i++){
                    rowSum[i] += matrix[i][r];
                }
                max = Math.max(max, dpmax(rowSum, k));
            }
        }
        return max;

    }
    private int dpmax(int[] arr, int k){
        int max = Integer.MIN_VALUE;
        for(int l = 0 ; l < arr.length; l++){
            int sum = 0;
            for(int r = l; r < arr.length; r++){
                sum+=arr[r];
                if(sum > max && sum <= k) max= sum;
            }
        }
        return max;
    }
}