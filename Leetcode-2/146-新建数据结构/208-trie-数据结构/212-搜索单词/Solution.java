class Trie{
    HashMap<Character, Trie> children;
    
    String word;
    public Trie(){
        children = new HashMap<Character, Trie>();
        word = null;
    }

}
class Solution {
    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();

        for(String word : words){
            Trie node = root;
            int len = word.length();
            for(int i = 0; i < len; i++){
                char c = word.charAt(i);
                if(!node.children.containsKey(c)){
                    node.children.put(c, new Trie());
                    
                }
                node = node.children.get(c);
            }
            node.word= word;
        }


        this._board = board;
        for(int r = 0 ; r < board.length; r++){
            for(int c =0 ; c < board[0].length; c++){
                if(root.children.containsKey(board[r][c])){
                    backtrace(r,c,root);
                }
            }
        }
        return this._result;
    }
   
    private void backtrace(int r, int c, Trie node){
        char letter = _board[r][c];
        Trie cur = node.children.get(letter);

        if(cur.word != null){
            this._result.add(cur.word);
            cur.word = null;
        }

        this._board[r][c] = '$';
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i = 0; i < 4; i++){
            int row = r +direction[i][0];
            int col = c + direction[i][1];
            if(row < 0 || row >= this._board.length || col <0 || col >= this._board[0].length){
                continue;
            }

            if(cur.children.containsKey(this._board[row][col])){
                backtrace(row, col, cur);
            }
        }

        this._board[r][c] = letter;
        if(cur.children.isEmpty()){
            node.children.remove(letter);
        }
    }
}