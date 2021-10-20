public class Solution {

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        if(r == 0) return false;
        int c = board[0].length;
        if(c == 0) return false;
        int wlen = word.length();
        if(wlen == 0) return false;
         
         
        boolean[][] visited= new boolean[r][c];
        
        for(int i = 0 ; i < r; i++){
            for(int j = 0; j < c; j++){
               
                    if(helper(board, visited, word, i, j, 0 )){
                        return true;
                    }
                
            }
        }
        return false;
    }
     
    public boolean helper(char[][] board, boolean[][] visited, String word, int x, int y, int index){
        if(index == word.length()){
            return true;
        }
        if(x<0 || x >= board.length || y <0 || y >= board[0].length|| visited[x][y]||word.charAt(index) != board[x][y]){
            return false;
        }
        visited[x][y] = true;
        boolean res = helper(board, visited, word,  x - 1, y, index + 1) ||
            helper(board, visited,word,  x + 1, y, index + 1) ||
            helper(board, visited,word,  x  , y-1, index + 1)||
            helper(board,visited, word,  x, y+1, index + 1);
        visited[x][y] = false;
        return res;
    }
}