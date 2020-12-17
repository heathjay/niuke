class Solution {
    public int myAtoi(String s2) {
        String s = s2.trim();
        int len = s.length();
        if(len == 0 || s == null) return 0;
        int start = 0;
        int flag = 1;
        if(s.charAt(start) == '+'){
            start = 1;
        }else if(s.charAt(start) == '-'){
            flag = -1;
            start = 1;
        }
        if(start >= len) return 0;
        if(!(s.charAt(start) >= '0' && s.charAt(start) <= '9')){
            return 0;
        }
        int bound = Integer.MAX_VALUE / 10;
        int sum = 0;
        while(start<len){
            if(!(s.charAt(start) >= '0' && s.charAt(start) <= '9')){
                break;
            }
            int c = s.charAt(start) - '0';
            if(sum > bound){
                return flag==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            if(sum == bound ){
                if(flag == 1 && c >= 7) return Integer.MAX_VALUE;
                else if(flag == -1 && c >= 8) return Integer.MIN_VALUE;
            }
            sum = sum * 10 + c;
            start++;
        }
        return sum * flag;
    }
}