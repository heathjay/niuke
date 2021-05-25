class Solution {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int res = 0;
        for(int i = 0 ; i < len ; i++){
            char c = columnTitle.charAt(i);
            res = res * 26 + c - 'A' +1;
        }
        return res;
    }
}