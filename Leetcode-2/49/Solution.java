import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}