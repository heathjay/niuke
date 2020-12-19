class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0 || nums==null) return 0;
        int i=0;
        for(int j =0; j < len ;j++){
            if(nums[j] == val){
                continue;
            }else{
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}