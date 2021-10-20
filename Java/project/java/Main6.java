import java.util.Stack;

public class Main6{
    public static void main(String[] args){
        //String s = "3(N2(SE))";
        String s = "3(N(S2(E)))";
//3(NSESE)
//NSESENSESENSESE
//N2
    //SE
        char[] c = s.toCharArray();
        String res = dfs(c);
        System.out.println(res);
    }
    static int index = 0;
    public static boolean isDigit(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
    public static String dfs(char[] c){
        if(c == null || c.length == 0) return "";
        int num = 0;
        
        StringBuilder sb = new StringBuilder();
        while(index < c.length){
            char tmp = c[index];
            if(tmp == '('){
                index++;
               
                String later = dfs(c);
                for(int i = 0 ;i < num-1; i++){
                    sb.append(later);
                }
                sb.append(later);
              
            }else if(tmp == ')'){
                index ++;
                String s = sb.toString();
                return sb.toString();
            }else if(isDigit(tmp)){
                num = num * 10 + (int)(tmp - '0');
                index++;
            }else{
                sb.append(tmp);
                index++;
            }
        }
        return sb.toString();
    }
}