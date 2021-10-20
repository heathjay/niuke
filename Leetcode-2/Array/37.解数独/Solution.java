class Solution {    
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];
    boolean valid = false;
    List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {

        int rLen = board.length;
        if(rLen == 0) return;
        int cLen = board[0].length;
        if(cLen == 0) return;

        for(int i = 0 ; i < rLen; i++){
            for(int j = 0 ; j < cLen; j++){
                if(board[i][j] == '.'){
                    spaces.add(new int[]{i,j});
                }else{
                    int num = board[i][j] - '0';
                    rows[i][num-1] = true;
                    cols[j][num-1] = true;
                    int boxind = (i / 3) * 3+ (j/ 3);
                    boxes[boxind][num-1] = true;
                }
            }
        }
        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos){
        if(pos == spaces.size()){
            valid=true;
            return;
        }

        
        int i = spaces.get(pos)[0], j = spaces.get(pos)[1];
        for(int digit = 0; digit < 9 && !valid; digit++){
            if(!rows[i][digit] && !cols[j][digit] && !boxes[(i/3) * 3 + j / 3][digit]){
                rows[i][digit]=cols[j][digit]= boxes[(i/3) * 3 + j / 3][digit]= true;
                board[i][j]=(char)(digit+'0'+1);
                dfs(board,pos+1);
                rows[i][digit]=cols[j][digit]= boxes[(i/3) * 3 + j / 3][digit]=false;
            }
        }
    }
}