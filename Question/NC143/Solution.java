import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param a int整型二维数组 第一个矩阵
     * @param b int整型二维数组 第二个矩阵
     * @return int整型二维数组
     */
    public int[][] solve (int[][] a, int[][] b) {
        // write code here
        int n = a.length;
        int[][] res;
        if(n <= 0) return res;
        res = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                for(int m =0 ; m < n; m++){
                    res[i][j] += a[i][m] * b[m][j];
                }
            }
        }
        return res;
    }
}