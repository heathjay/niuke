public Solution{
    public String longestPalindrome(String s) {
        int len = s.length()；
        if(len <= 1) return s;
        int maxLen = 1;
        String res = s.substring(0,1);
        for(int i = 0; i < len-1; i++){
            String odd = getCentral(s, i, i);
            String even = getCentral(s,i, i+1);
            String maxLenString = odd.length() > even.length() ? odd : even;
            if(maxLenString.length() > maxLen){
                maxLen = maxLenString.length();
                res = maxLenString;
            }
        }
        return res;
    }
    public String getCentral(String s, int left, int right){
        int len = s.length();
        while(left >= 0 && right < len){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;

            }else{
                break;
            }
        }
        return s.substring(left+1,right);
    }
}


public Solution1{
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) return s;
        boolean[][] dp = new boolean[len][len];

        int maxlen = 1;
        int begin = 0;
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        for(int j = 1;j < len;j++){
            for(int i =0; i < j; i++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j]= dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxlen){
                    maxlen = j-i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }
}