class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(len == 0 || nums == null) return res;
        Arrays.sort(nums);
        for(int first = 0; first < len; first++){
            if(first> 0 && nums[first] == nums[first-1]){
                continue;
            }

            int third = len-1;
            int sec = first+1;

            int target = -nums[first];

            /*
            for(int sec = first + 1; sec < len; sec++){
                if(sec > first+1 && nums[sec] == nums[sec-1]){
                    continue;
                }
                while(sec<third && nums[sec] + nums[third] > target){
                    third--;
                }
                if(sec == third){
                    break;
                }
                if(nums[sec] + nums[third] == target){
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[first]);
                    ans.add(nums[sec]);
                    ans.add(nums[third]);
                    res.add(ans);
                }
            }
            */
            while(sec < third){
                if(sec > first + 1 && nums[sec] == nums[sec - 1]){
                    sec++;
                    continue;
                }
                int sum = nums[sec] + nums[third];
                if(sum > target){
                    third--;
                }else if(sum < target){
                    sec++;
                }else{
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[first]);
                    ans.add(nums[sec]);
                    ans.add(nums[third]);
                    res.add(ans);
                    sec++;
                }
            }
        }
        return res;
    }
}