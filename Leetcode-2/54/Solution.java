import java.util.List;


import java.util.ArrayList;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length;
        int[][] dist = {{0,1}, {1,0}, {0,-1},{-1,0}};
        boolean[][] visited = new boolean[m][n];
        int index = 0;
        int i = 0;
        int j = 0;
        while(res.size() < m *n){
            res.add(matrix[i][j]);
            visited[i][j] = true;
            if(  i + dist[index][0] < 0 ||  i + dist[index][0] >=m ||  j + dist[index][1]<0 ||j + dist[index][1]>=n || visited[i + dist[index][0]][j + dist[index][1]]){
                index=(index+1)%4;
            }
            i = i + dist[index][0];
            j = j + dist[index][1];
        }
        return res;
    }
}