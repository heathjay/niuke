class Solution {
    public void sortColors(int[] nums) {
        int p = 0, len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }
        for(int i = p; i < len ; i++){
            if(nums[i] == 1){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }

    }

    public void sortColors1(int[] nums) {
        int len = nums.length;
     
        int left = 0, right = len - 1;
       int index = 0;
       while(index <= right){
           if(index < left){
               index++;
           }else if(nums[index] ==0){
               int tmp = nums[index];
               nums[index] = nums[left];
               nums[left] = tmp;
               left++;
           }else if(nums[index] == 2){
            int tmp = nums[index];
            nums[index] = nums[right];
            nums[right] = tmp;
           right--;
           }else{
               index++;
           }
       }

    }
}