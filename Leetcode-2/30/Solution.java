import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int Nums = words.length;
        int strLen = s.length();
        if(strLen == 0 ||Nums==0) return res;
        HashMap<String,Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word , map.getOrDefault(word,0)+1);
        }
        int wordLen = words[0].length();
        for(int i= 0; i < strLen- wordLen * Nums + 1;i++){
            int index = 0;
            HashMap<String,Integer> tmp = new HashMap<>();
            while(index < Nums){
                String w = s.substring(i + wordLen * index, i+ wordLen * (index+1));
                if(map.containsKey(w)){
                    tmp.put(w,tmp.getOrDefault(w,0) + 1);
                    if(tmp.get(w) > map.get(w)){
                        break;
                    }
                   
                }else{
                    break;
                }
                index++;
            }
            if(Nums == index){
                res.add(i);
            }
        }
        return res;

    }
}