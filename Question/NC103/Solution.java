import java.util.*;


public class Solution {
    /**
     * 反转字符串
     * @param str string字符串 
     * @return string字符串
     */
    public String solve (String str) {
        // write code here
        if(str == null || str.length() == 0 || str.length() == 1){
            return str;
        }

        char[] arr = str.toCharArray();
        for(int i = 0 ; i < arr.length/2; i++){
            char tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        return new String(arr);
    }
}