import java.util.*;


public class Solution {
    /**
     * 
     * @param S string字符串 
     * @param T string字符串 
     * @return string字符串
     */
    public String minWindow (String S, String T) {
        // write code here
        int lenS = S.length();
        int lenT = T.length();
        if(lenT > lenS){
            return "";
        }
        Map<Character, Integer> fix = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            fix.put(c, fix.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> win = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        
        int size = 0;
        int min = Integer.MAX_VALUE;
        
        while(right < lenS){
            char c = S.charAt(right);
            if(fix.containsKey(c)){
                win.put(c, win.getOrDefault(c, 0) + 1);
                if(win.get(c).equals(fix.get(c))){
                    size++;
                }
            }
            
            right++;
            //【left, right
            while(size == fix.size()){
                if(right - left  < min){
                    min = right -left;
                    start = left;
                    end = right;
                }
                char c1 = S.charAt(left);
                if(fix.containsKey(c1)){
                    win.put(c1,win.get(c1) -1);
                    if(win.get(c1) < fix.get(c1)){
                        size--;
                    }
                }
                left++;
            }
        }
        return end - start == 0 ? "" : S.substring(start,end);
        
      
     
        
        
    }
}