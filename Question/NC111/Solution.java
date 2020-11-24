import java.util.*;


public class Solution {
    /**
     * 最大数
     * @param nums int整型一维数组 
     * @return string字符串
     */
    private class LargerNumberComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
    public String solve (int[] nums) {
        // write code here

        String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, new LargerNumberComparator());

        if(s[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String t : s){
            sb.append(t);
        }
        return sb.toString();
    }
}


class Solution {
    public String largestNumber(int[] nums) {
        Integer [] x  =  Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(x, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = String.valueOf(o1);
                String str2 = String.valueOf(o2);     
                return (new StringBuilder().append(str2).append(str1)).compareTo(new StringBuilder().append(str1).append(str2));
            }
        });
        StringBuilder string = new StringBuilder();
        for(Integer num:x){
            string.append(num);
        }
        if (string.charAt(0) == '0') {
            return "0";
        }
        return string.toString();
    }
}

