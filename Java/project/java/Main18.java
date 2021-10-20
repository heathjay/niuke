import java.util.*;


public class Main18 {
    /**
     * 
     * @param str string字符串 
     * @return string字符串
     */
    static int index = 0;
    public static String computeString (String str) {
        // write code here
        int len = str.length();
        if(len <= 0){
            return "";
        }
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(index < len){
            char c = str.charAt(index);
            if(isDigital(c)){
                num = num * 10 + (c - '0');
                index++;
            }else if(c == '*'){
                stack.push(num);
                num = 0;
                index++;
            }else if(c == '['){
                index++;
                String tmp = computeString(str.substring(index));
                if(!stack.isEmpty()){
                    int n = stack.pop();
                    StringBuilder tmpn = new StringBuilder();
                    for(int i = 0; i< n;i++){
                        tmpn.append(tmp);
                    }
                    sb.append(tmpn);
                }else{
                    sb.append(tmp);
                }
                return sb.toString();
                
            }else if(c == ']'){
                index++;
                return sb.toString();
            }else{
                sb.append(c);
                index++;
            }
           
        }
        return sb.toString();
        
    }
    public static boolean isDigital(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String s = "3*[a2*[c]]";
        System.out.println( computeString(s));
    }
}