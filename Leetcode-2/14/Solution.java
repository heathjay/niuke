class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for(int i = 1; i < count; i++){
            prefix = longestCommonPrefix(prefix, strs[i]);
            if(prefix.length() == 0) break;
        }
        return prefix;
    }
    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while(index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0,index);
    }

    public String longestCommonPrefix1(String[] strs) {
        int len = strs.length;
        if (len == 0 || strs == null) return "";
        int count = strs[0].length();

        for(int i=0; i < count; i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < len;j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }


    public String longestCommonPrefix3(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }else{
            return longestCommonPrefix3(strs, 0, strs.length-1)
        }
    }
    public String longestCommonPrefix3(String[] strs, int start, int end) {
        if(start == end){
            return strs[start];
        }else{
            int mid = (end - start) / 2 + start;
            String left = longestCommonPrefix3(strs, start, mid );
            String right = longestCommonPrefix3(strs, mid + 1, end);
            return common(left,right);
        }
    }
    public String common(String str1, String str2) {
        int minlen = Math.min(str1.length(), str2.length());
        for(int i = 0; i < minlen; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return str1.substring(0,i);
            }
        }
        return str1.substring(0, minlen);
    }
}