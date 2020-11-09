import java.util.*;


public class Solution {
    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组 
     * @return int整型
     */
    public int solve (char[][] grid) {
        // write code here
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] =='1'){
                    Queue queue = new LinkedList();
                    queue.offer(new Point(i,j));
                    grid[i][j] = '0';
                    bfs(queue, grid);
                    count++;
                }
            }
        }
        return count;
    }
    class Point{
        int x;
        int y;
        Point(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
    public void bfs(Queue queue, char[][] grid){
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            if(x-1 >= 0 && grid[x-1][y] == '1'){
                queue.offer(new Point(x-1,y));
                grid[x-1][y] = '0';
            }

            if(y - 1 >= 0 &&grid[x][y-1] == '1'){
                queue.offer(new Point(x,y-1));
                grid[x][y-1] = '0'; 
            }

            if(x+1 < grid.length && grid[x+1][y] == '1'){
                queue.offer(new Point(x+1,y));
                grid[x+1][y]='0';
            }

            if(y+1 < grid[0].length && grid[x][y+1] == '1' ){
                queue.offer(new Point(x, y + 1));
                grid[x][y+1] = '0';
            }
        }
    }
}