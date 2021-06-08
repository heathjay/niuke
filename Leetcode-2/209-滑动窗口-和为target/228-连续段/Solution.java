class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return res;
        if(len == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        int i = 0;
       
        while(i < len){
            int low = i;
            i++;
            while(i < len && nums[i] - nums[i-1] == 1){
                i++;
            }
            int high = i-1;
            StringBuilder tmp = new StringBuilder();
            tmp.append(Integer.toString(nums[low]) );
            if(high > low){
                tmp.append("->");
                tmp.append(Integer.toString(nums[high]) );
            }
            res.add(tmp.toString());
        }
        return res;
    }
}