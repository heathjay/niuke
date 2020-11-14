import java.util.*;


public class Solution {
    /**
     * 
     * @param n int整型 
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(String str, int open, int close, int n, List<String> result){
        if(str.length() == n << 1){
            result.add(str);
            return;
        }

        if(open < n){
            backtrack(str + "(", open+1,close, n, result);
        }
        if(close<open){
            backtrack(str + ")", open,close+1,n,result);
        }
    }
}