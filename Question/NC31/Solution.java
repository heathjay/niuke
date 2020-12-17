import java.util.*;


public class Solution {
    /**
     * 
     * @param matrix int整型二维数组 the matrix
     * @return int整型一维数组
     */
    public int[] printMatrix (int[][] matrix) {
        // write code here

        int n = matrix.length;
        if(n == 0 || matrix == null) return null;

        int m = matrix[0].length;
        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;
        
        int idx = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while(true){
            for(int i = left; i <= right; i++){
                res[idx++] = matrix[top][i];
            }
            if(++top > bottom){
                break;
            }

            for(int i = top; i <= bottom;i++){
                res[idx++] = matrix[i][right];
            }
            if(left > --right){
                break;
            }

            for(int i = right; i >= left; i--){
                res[idx++] = matrix[bottom][i];
            }
            if(top > --bottom){
                break;
            }

            for(int i = bottom; i >= top;i--){
                res[idx++] = matrix[i][left];
            }
            if(++left > right){
                break;
            }

        }
        return res;
    }
}