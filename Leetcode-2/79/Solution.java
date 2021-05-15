/*
class Solution {


    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int len = word.length();
        if(r == 0 && len != 0) return false;
        if(len == 0) return true;
        int c = board[0].length;
        if(c == 0) return false;
        boolean flag = false;

        boolean[][] used = new boolean[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(flag){
                    return true;
                }
                backtrace(flag, used, board, word, 0, i, j);
            }
        }
        return false;
    }

    public void backtrace(boolean flag, boolean[][] used, char[][] board, String word, int index, int row, int col){
        if(word.length()-1 == sb.length() && board[row][col] == word.charAt(word.length()-1)){
            flag = true;
            return;
        }
        if(board[row][col] != word.charAt(index)){
            return;
        }

                
                   
                    used[i][j] = true;
                    if(i+1 >= 0 && i+1 < board.length && !used[i+1][j]){
                        backtrace(flag, used, board, word, index+1, i+1, col);
                    }
                    if(i-1 >= 0  && i-1 < board.length && !used[i-1][j]){
                        backtrace(flag, used, board, word, index+1, i-1, col);
                    }

                    if(j-1 >= 0 && j-1 < board[0].length && !used[i][j-1]){
                        backtrace(flag, used, board, word, index+1, i, col-1);
                    }

                    if(j+1  < board.length && j+1 >=0&& !used[i][j+1]){
                        backtrace(flag, used, board, word, index+1, i, col+1);
                    }
                    
                    used[i][j] = false;



    }

}
*/

class Solution{
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        boolean[][] used = new boolean[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                boolean flag = backtrace(word, 0, board, used, i, j);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrace(String word, int index, char[][] board, boolean[][] used, int i, int j){
        if(board[row][col] != word.charAt(index)){
            return false;
        }else if(index == word.length()-1){
           
            return true;
        }

        used[i][j] = true;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean result = false;
        for(int[] dir : directions){
            int newi = i + dir[0], newj = j + dir[1];
            if(newi >=0 && newi < board.length && newj >=0 && newj < board[0].length){
                if(!used[newi][newj]){
                    boolean flag = backtrace(word, index+1, board, used, newi, newj);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            
            }
        }
        used[i][j] =false;
        return result;

     
    }
}