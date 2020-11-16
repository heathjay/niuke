import java.util.*;

public class Rotate {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
                //对角线
                for(int i = 0; i < n - 1; i++){
                    for(int j = i + 1; j < n ; j++){
                        int tmp = mat[i][j];
                        mat[i][j] = mat[j][i];
                        mat[j][i] = tmp;
                    }
                }
        //中心对称
        int mid = n / 2;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < mid ; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n-1-j] = tmp;
            }
        }
        return mat;
    }
}