import java.util.*;


public class Solution {
    /**
     * 
     * @param s string字符串 
     * @return string字符串ArrayList
     */
    ArrayList<String> res = new ArrayList<>();

    int[] segements = new int[4];


    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        segements = new int[4];
        dfs(s,0,0);
        return res;
    }


    public void dfs(String s, int segId, int segStart){
        if(segId == 4){
            if(segStart == s.length()){
                StringBuffer sb = new StringBuffer();
                for(int i = 0 ; i < 4; i++){
                    sb.append(segements[i]);
                    if(i != 3){
                        sb.append('.');
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        //遍历完已经不够
        if(segStart == s.length()){
            return;
        }

        if(s.charAt(segStart) == '0'){
            segements[segId] = 0;
            dfs(s,segId+1,segStart + 1);
        }

        int addr = 0;
        for(int segEnd = segStart; segEnd < s.length(); segEnd++){
            addr = addr * 10 + s.charAt(segEnd) - '0';
            if(addr > 0 && addr <= 0XFF){
                segements[segId] = addr;
                dfs(s, segId + 1, segEnd+1);
            }else{
                break;
            }
        }
    }
}