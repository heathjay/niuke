import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = matrix.length, m = matrix[0].length;
        boolean[][] val = new boolean[n][m];
        ArrayList<> res = new ArrayList<Integer>();
        int x = 0, y = 0, dir = 0;
        while(x >= 0 && x < n && y >= 0 && y < m && !val[x][y]){
           res.add(matrix[x][y]);
           val[x][y] = true;
           while(x + dx[dir] >= 0 && x + dx[dir] < n && y + dy[dir] >=0 && y + dy[dir] < m && !val[x+dx[dir]][y+dy[dir]]){
                x += dx[dir]
                y += dy[dir]
                res.add(matrix[x][y]);
                val[x][y] = true;
           } 
           dir = (dir + 1) % 4;
           x += dx[dir];
           y += dy[dir];
        }
        return res;
    }
}