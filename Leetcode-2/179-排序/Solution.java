class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] s = new String[len];
        for(int i = 0; i < len; i++){
            s[i] = nums[i]+"";
        }

        Arrays.sort(s,(a,b) -> {
            return (b+a).compareTo(a+b);
        });

        StringBuilder sb = new StringBuilder();
        for(String ss : s) sb.append(ss);

        int k = 0;
        while(k < len-1 && sb.charAt(k) == '0')k++;
        return sb.substring(k);
    }
