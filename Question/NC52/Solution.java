import java.util.*;


public class Solution {
    /**
     * 
     * @param s string字符串 
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        char[] sarry = s.toCharArray();
        int length = sarry.length;
        if(length == 0) return true;
        for(int i = 0; i < length;i++){
            if(sarry[i] == '[' || sarry[i] == '(' || sarry[i] == '{'){
                stack.push(sarry[i]);
            }else if(sarry[i] == ']' ){
                if(stack.isEmpty()) return false;
                char tmp = stack.pop();
                if(tmp != '[') return false;
            }else if(sarry[i] == ')'){
                if(stack.isEmpty()) return false;
                char tmp = stack.pop();
                if(tmp != '(' ) return false;
            }else if(sarry[i] == '}'){
                if(stack.isEmpty()) return false;
                char tmp = stack.pop();
                if(tmp != '{' ) return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}