class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        if(i < 0  || i >= rows || j < 0|| j >= cols || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i ,j +1);
        dfs(grid, i, j-1);
    }
}