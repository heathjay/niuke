class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1 == 0 && len2 == 0) return 0;
        if(len1 == 0) return -1;
        if(len2 == 0) return 0;
        if(len1 < len2) return -1;
        for(int i = 0; i <= len1 - len2 ;i++){
            int j = 0;
            if(haystack.charAt(i) != needle.charAt(j)){
                continue;
            }else{
                for(;j<len2;j++){
                    if(haystack.charAt(i+j) != needle.charAt(j) ){
                        break;
                    }
                }
                if(j == len2){
                    return i;
                }
            }
        }
        return -1;
    }
    public int strStr1(String haystack, String needle) {

        int L = needle.length();
        int n = haystack.length();
        if(L == 0) return 0;
        int pn = 0;
        while(n-L+1 > pn){
            while(pn < n-L+1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;
            int curLen = 0, pL = 0;
            while(pL < L && pn < n && haystack.charAt(pn) == needle.charAt((pL))){
                ++pn;
                ++pL;
                ++curLen;
            }
            if(curLen == L) return pn-L;
            pn = pn - curLen+1;
        }
        return -1;
    }
}