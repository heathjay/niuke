import java.util.*;


public class Solution {
    /**
     * 
     * @param matrix int整型二维数组 
     * @param target int整型 
     * @return bool布尔型
     */
    public boolean searchMatrix (int[][] matrix, int target) {
        // write code here
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        if(matrix[0][0] > target) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n-1;

        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
                continue;
            }else if(matrix[i][j] < target){
                i++;
                continue;
            }
        }
        return false;
    }
}