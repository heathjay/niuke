class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        int r = board.length;
        if(r == 0) return false;
        int c = board[0].length;
        if(c == 0) return false;
        for (int i = 0; i < 9; i++) {
        rows[i] = new HashMap<Integer, Integer>();
        cols[i] = new HashMap<Integer, Integer>();
        boxes[i] = new HashMap<Integer, Integer>();
        }

        for(int i = 0; i < r; i++ ){
            for(int j = 0; j < c ; j++){
                char n = board[i][j];
                if(n != '.'){
                    int num = board[i][j] - '0';
                    rows[i].put(num, rows[i].getOrDefault(num,0) + 1);
                    cols[j].put(num, cols[j].getOrDefault(num,0) + 1);
                    int box = (i / 3) * 3 + j / 3;
                    boxes[box].put(num, boxes[box].getOrDefault(num,0) + 1);
                    if(rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxes[box].get(num) > 1){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}