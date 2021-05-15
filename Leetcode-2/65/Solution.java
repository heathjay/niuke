class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        String tmp = s.trim();
        int len = tmp.length();
        if(len == 0 || tmp == null) return false;
        boolean numFlag = false;
        boolean eFlag = false;
        boolean dotFlag = false;
        char arr[] = tmp.toCharArray();
        for(int i = 0 ; i < len; i++){
            if(arr[i] >= '0' && arr[i] <= '9'){
                numFlag = true;
            }else if(arr[i] == 'e' || arr[i] == 'E'){
                if(eFlag || !numFlag || (i == 0) || (i == len-1)){
                    return false;
                }
                eFlag = true;
                numFlag = false;
            }else if(arr[i] == '.'){
                if(dotFlag || eFlag ){
                    return false;
                }
                dotFlag = true;
            }else if(arr[i] == '+' || arr[i] == '-'){
                if(i !=0 && (arr[i-1] != 'e') && (arr[i-1] != 'E')){
                    return false;
                }
                numFlag=false;
            }else{
                return false;
            }
            
        }
        return numFlag;
    }
}

