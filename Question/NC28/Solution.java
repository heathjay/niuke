import java.util.*;


public class Solution {
    /**
     * 
     * @param S string字符串 
     * @param T string字符串 
     * @return string字符串
     */
    HashMap<Character,Integer> ori = new HashMap<>();
    HashMap<Character,Integer> cnt = new HashMap<>();
    public String minWindow (String S, String T) {
        // write code here
        int tlen = T.length();

        int sLen = S.length();
        if(sLen == 0 || S == null || tlen == 0|| T == null) return null;
        for(int i = 0; i < tlen ; i++){
            ori.put(T.charAt(i),ori.getOrDefault(T.charAt(i), 0) + 1);
        }

        int left = 0, right =-1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        while(right < sLen){
            ++right;
            if(right < sLen && ori.containsKey(S.charAt(right))){
                cnt.put(S.charAt(right), cnt.getOrDefault(S.charAt(right), 0 )+ 1);
            }
            while(check() && left <= right){
                if(right - left + 1 < len){
                    len = right - left + 1;
                    ansL = left;
                    ansR = left + len;
                }
                if(ori.containsKey(S.charAt(left))){
                    cnt.put(S.charAt(left), cnt.getOrDefault(S.charAt(left), 0 )-1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : S.substring(ansL, ansR);
    }

    public boolean check(){
        Iterator iter = ori.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if(cnt.getOrDefault(key,0) < val){
                return false;
            } 
        }
        return true;
    }
}