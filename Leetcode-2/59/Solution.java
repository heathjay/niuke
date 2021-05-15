class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int left = 0, right = n-1, top = 0, bottom = n-1;
        while(left <= right && top <= bottom){
            for(int c = left ; c <= right; c++ ){
                res[top][c] = count;
                count++;
            }
            top++;
            for(int r = top; r <= bottom ; r++){
                res[r][right] = count;
                count++;
            }
            right--;
            for(int c = right; c >= left; c--){
                res[bottom][c] = count;
                count++;
            }
            bottom--;
            for(int r = bottom; r >= top; r--){
                res[r][left] = count;
                count++;
            }
            left++;
        }
        return res;
    }
}