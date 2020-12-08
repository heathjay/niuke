import java.util.*;


public class Solution {
    /**
     * 
     * @param strs string字符串一维数组 the strings
     * @return string字符串
     */
    public class newComparator implements Comparator<String>{
        	@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
    }
       public String minString (String[] strs) {
        // write code here

        int len = strs.length;
        if(len == 0 || strs == null) return null;
        Arrays.sort(strs, new newComparator());
         StringBuilder sb = new StringBuilder();
           for(int i = 0; i < len; i++){
               sb.append(strs[i]);
         }  
           return sb.toString();
      }


}