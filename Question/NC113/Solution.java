import java.util.*;


public class Solution {
    /**
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve (String IP) {
        // write code here
        return validIPv4(IP) ? "IPv4" :(validIPv6(IP) ? "IPv6" : "Neither");
    }

    private boolean validIPv4(String IP){
        String[] strs = IP.split("\\.", - 1);
        if(strs.length != 4) return false;

        for(String str : strs){
            if(str.length() > 1 && str.startsWith("0")){
                return false;
            }

            try{
                int val = Integer.parseInt(str);
                if(!(val >= 0 && val <= 255)){
                    return false;
                }
            }catch(NumberFormatException numberFormatException){
                return false;
            }
        }

        return true;
    }




    private boolean validIPv6(String IP){
        String[] strs = IP.split(":", -1);
        if(strs.length != 8){
            return  false;
        }

        for(String str : strs){
            if(str.length() > 4 || str.length() == 0){
                return false;
            }

            try{
                int val = Integer.parseInt(str,16);
            }catch(NumberFormatException numberFormatException){
                return false;
            }
        }
        return true;
    }

}