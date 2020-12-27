class Solution {
    public void solveSudoku(char[][] board) {
         backTrace(board, 0, 0);
    }

    public boolean backTrace(char[][] board, int row, int col){
        if(row == board.length) return true;
        if(col == board.length){
            return backTrace(board, row+1, 0);
        }

        if(board[row][col] != '.'){
            return backTrace(board, row, col+1);
        }

        for(char i = '1'; i <= '9'; i++){
            if(!isValid(board, row, col,i)){
                continue;
            }
            board[row][col] = i;
            if(backTrace(board, row, col)){
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    public static boolean isValid(char[][] board, int row, int col,char c){
        for(int i = 0;i < 9 ;i++){
            if(board[i][col] == i){
                return false;
            }
            if(board[row][i] == i){
                return false;
            }
            if(board[3 * (row/3) + i / 3][3 * (col/3) + i %3] == c){
                return false;
            }
        }
        return true;
    }
}