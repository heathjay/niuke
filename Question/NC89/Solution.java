import java.util.*;

public class Transform {
    public String trans(String s, int n) {
        // write code here

        if(n == 0 || s == null) return null;

        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length-1; i >= 0;i--){
            sb.append(ss[i] + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        return change(sb.toString());
    }

    public String change(String s){
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n ; i++){
            char tmp = s.charAt(i);
            if(tmp >= 'a' && tmp<='z'){
                tmp=(char)(tmp - 32);
            }else if(tmp >= 'A' && tmp <= 'Z'){
                tmp=(char)(tmp + 32);
            }
            sb.append(tmp);
        }
        return sb.toString();
    }
}