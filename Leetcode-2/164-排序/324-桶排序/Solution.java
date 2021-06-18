class Solution {
    public  void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        for(int num : nums){
            bucket[num] ++;
        }

        int len = nums.length;
        int small, big;
        //总长度为奇数的时候，小 大 小 大 小
        //总长度为偶数的时候，小 大 小 大
        if((len & 1) == 1){
            small = len-1;
            big = len-2;
        }else{
            small = len-2;
            big = len-1;
        }

        int j = 5000;

        //从后往前插入数组，后为j
        //桶中大的数字在后面，小的数字在前面，先去取出较大的数字，然后再小的数字
        for(int i = 1; i <= big; i+=2){
            while( bucket[j] == 0) j--;
            nums[i] = j;
            bucket[j] --;
        }

        for(int i = 0; i <= small; i+=2){
            while(bucket[j] == 0) j--;
            nums[i] = j;
            bucket[j]--;
        }


    }
}