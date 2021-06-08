class Solution {
    public boolean containsDuplicate1(int[] nums) {
        int len = nums.length;
        Set<Integer> set =new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }

            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}