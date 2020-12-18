import java.util.*;


public class Solution {
    /**
     * 比较版本号
     * @param version1 string字符串 
     * @param version2 string字符串 
     * @return int整型
     */
    public int compare (String version1, String version2) {
        // write code here
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        int len =Math.min(v1.length, v2.length);
        for(int i = 0; i < len; i++){
            if(v1[i].equals(v2[i])) continue;
            if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                return 1;
            }else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                return -1;
            }
        }
        if(v1.length > v2.length){
            return 1;
        }else if(v1.length < v2.length){
            return -1;
        }
        return 0;
    }
}
