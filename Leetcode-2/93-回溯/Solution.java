import java.util.List;
import java.util.ArrayList;

class Solution {

    List<String> res = new ArrayList<>();
    static final int SEG_COUNT = 4;
    int[] segments = new int[SEG_COUNT];


    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(0,0,s);
        return res;
    }


    public void dfs(int segId, int segStart, String s){
        if(segId == SEG_COUNT){
            if(segStart == s.length()){
                StringBuffer ipAddr = new StringBuffer();
                for(int i = 0; i < SEG_COUNT; i++){
                    ipAddr.append(segments[i]);
                    if(i != SEG_COUNT - 1){
                        ipAddr.append('.');
                    }
                }
                res.add(ipAddr.toString());
            }
            return ;
        }

        if(segStart == s.length()){
            return;
        }

        if(s.charAt(segStart) == '0'){
            segments[segId] = 0;
            dfs(segId+1, segStart+1, s);
        }

        int addr = 0;
        for(int segEnd = segStart; segEnd < s.length(); segEnd++){
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if(addr > 0 && addr <= 255){
                segments[segId] = addr;
                dfs(segId+1, segEnd + 1, s);
            }else{
                break;
            }
        }
    }
}