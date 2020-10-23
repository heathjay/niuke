public class Solution {
    //逆向遍历
    public String replaceSpace(StringBuffer str) {
        //长度的动态变化
        if(str.length() == 0 || str == null) return "";
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) == ' '){
                 str.deleteCharAt(i);
                str.insert(i,"%20");
                i=i+2;              
            }else{
                i++;
            }
        }
        return str.toString(); 
    }
}