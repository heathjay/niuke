import java.util.*;


public class Solution {
    /**
     * 
     * @param strs string字符串一维数组 
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        // write code here
        int minlengflag = 0;
        if(strs.length == 0) return "";
        int len = strs.length;
        for(int i = 0 ; i < len; i++){
            if(strs[i].length()< strs[minlengflag].length()){
                minlengflag = i;
            }
        }

        if(minlengflag != 0){
            String tmp = strs[minlengflag];
            strs[minlengflag] = strs[0];
            strs[0] = tmp;
        }

        for(int i = 0 ; i < strs[0].length(); i++){
            char x = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(x != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    
    }
}