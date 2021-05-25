class Solution {
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        if(len == 1) return ;

        k = k % len;
        int[] tmp =new int[k];
        for(int i =0; i < k;i++){
            tmp[i]=nums[len-k+i];
        }
        for(int i = len-1-k; i >= 0; i--){
            nums[i+k] = nums[i];
        }
        for(int i = 0;i < k;i++){
            nums[i]=tmp[i];
        }
    }
    public void reverse(int[] nums, int start, int end){
        while(end >start){
            int tmp = nums[start];
            nums[start]= nums[end];
            nums[end] = tmp;
            start++;
            end --;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums,0, k);
        reverse(nums, k+1, nums.length-1);
    }
}