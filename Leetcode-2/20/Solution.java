import java.util.Stack;
import java.util.HashMap;
class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Stack<Character> stack = new Stack();
        int len = s.length();
        if(len == 0 || s == null || len % 2 == 1)return true;
        for(int i = 0; i < len; i++){
            /*
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(!stack.isEmpty()&& (c == ')' || c == '}' || c == ']')){
                char t = stack.pop();
                if(t != map.get(c)){
                    return false;
                }
            }else{
                return false;
            }
            */

            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}