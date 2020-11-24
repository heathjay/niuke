public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0,0);
    }
    public boolean  isValid(char[][] board, int x, int y, char ch){
        for(int i = 0 ; i < 9 ;i++){
            if(board[x][i] == ch) return false;
            if(board[i][y] == ch) return false;
            if(board[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3] == ch) return false;
        }
        return true;
    }

    public boolean dfs(char[][] board, int x, int y){
        if( x == 9) return true;
        if( y == 9) return dfs(board, x + 1, 0);
        if(board[x][y] != '.') return dfs(board, x, y+1);

        for(char c = '1' ; c <= '9' ; c++){
            if(!isValid(board, x, y, c)) continue;
            board[x][y] = c;
            if(dfs(board,x,y+1)) return true;
            board[x][y] = '.';
        }
        return false;
    }
}