import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length;
        if(n == 0) return res;

        int[] dx = {0 , 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int total = n * m ;
        int i = 0, j =0;
        boolean[][] flag = new boolean[m][n];
        int index = 0;
        for(int count = 0 ; count < total ; count++){
            res.add(matrix[i][j]);
            flag[i][j] = true;
            int nexti = i + dx[index], nextj = j + dy[index];
            if(nexti < 0 || nexti >= m || nextj < 0 || nextj >= n || flag[nexti][nextj]){
                index = (index + 1) % 4;
            }
            i += dx[index];
            j += dy[index];
        }
        return res;
    }
}