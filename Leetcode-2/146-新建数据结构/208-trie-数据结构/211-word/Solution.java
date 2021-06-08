
class Trie{
    Trie[] children;
    boolean isEnd;
    Trie(){
        children = new Trie[26];
        isEnd = false;
    }
}
class WordDictionary {
    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = this.root;
        int len = word.length();
        for(int i = 0 ; i < len; i++){
            if(node.children[word.charAt(i) - 'a'] == null){
                node.children[word.charAt(i) - 'a'] = new Trie();
            }
            node = node.children[word.charAt(i) - 'a'];
        }

        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchWord(word, this.root);
    }

    public boolean searchWord(String word, Trie node){
        int len = word.length();
        
        for( int i = 0 ; i < len ; i++){
            char c = word.charAt(i);
            if(c != '.' && node.children[c-'a'] == null){
                return false;
            }

            if(c == '.'){
                for(int j = 0; j < 26; j++){
                    if(node.children[j] != null){
                        if(searchWord(word.substring(i+1), node.children[j])) return true;
                    }
                   
                }
                return false;
            }
            node = node.children[c-'a'];
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */